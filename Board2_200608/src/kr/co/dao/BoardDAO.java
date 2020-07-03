package kr.co.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.domain.BoardDTO;

public class BoardDAO {

	private DataSource dataFactory;

	public BoardDAO() {
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");  //context.xml
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	// closeAll method
	private void closeAll(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//list
	public List<BoardDTO> list() {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board order by repRoot desc, repStep asc";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num"); 
				String writer =  rs.getString("writer");
				String title = rs.getString("title");
				String writeday = rs.getString("writeday");
				int readcnt = rs.getInt("readcnt");
				//보기위해서 추가로
				int repRoot = rs.getInt("repRoot");
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				list.add(new BoardDTO(num, writer, title, null, writeday, readcnt, repRoot, repStep, repIndent));
			}
			
		} catch (Exception e) {
			e.printStackTrace();			
		} finally {
			closeAll(rs, pstmt, conn);
		}
		return list;
	}

	//insert
	public void insert(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num,writer,title,content,repRoot,repStep,repIndent) values(?,?,?,?,?,?,?)";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			//num 값 제조~~~  시퀀스 쓰지 않은 이유? 서버가 꺼졌다가 다시 켜지면 지멋대로 중복이 되기도 한다. 서비스업체(서버거 안꺼진다는 가정하에 사용한다)
			int num = createNum(conn);  //num 값과 insert는 같은 커넥션 가지고 작업을 해야한다! 트랜젝션(동일한 사건에 대해 여러개 CUD작업)은 아니다. 기존것 가져와서 더해서 1만하면되는것(R작업) 
			
			pstmt.setInt(1, num);
			pstmt.setString(2, boardDTO.getWriter());
			pstmt.setString(3, boardDTO.getTitle());
			pstmt.setString(4, boardDTO.getContent());
			pstmt.setInt(5, num);
			pstmt.setInt(6, 0);
			pstmt.setInt(7, 0);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	//createNum
	private int createNum(Connection conn) {
		PreparedStatement pstmt = null;
		String sql = "select max(num) from board"; //가장 큰 num 값 가져오기
		ResultSet rs = null;
		Integer num = null;  //null인경우 0을 반환~~ 
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				num = rs.getInt(1);  // max(num)이것의 컬럼명  
				
				num += 1; // 마이바틱스? dao, oracle 사이에..그건 null 반환함. 무슨소리인가 
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, null);  //주의! 
		}
		return num;
	}
	
	//read  (selectById같은 역할)
	public BoardDTO read(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		
		//트랜젝션  (1)
		boolean isOk = false; //변수 int 2개로 설정하기도 한다. 1과 0으로 코드 짜는경우도있다.... 정처리기사에서 알고리즘 부분에~ 
		
		try {
			conn = dataFactory.getConnection();
			//트랜젝션(4). autocommit 해제할 것
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			//readcnt 증가시키는 메서드!
			int readcnt = creatReadCnt(conn, num);
			
			if(rs.next()) {
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writeday = rs.getString("writeday");	  //date 형이지만 string으로 받겠다1 
				readcnt = rs.getInt("readcnt");
				dto = new BoardDTO(num, writer, title, content, writeday, readcnt, 0,0,0);
				//readcnt+1 : 눈에 보이는 것만 증가시키기! 반대로도 가능! 먼저 db에서 증가시키고 반영시키능 방법도 있다.  
				//문제: 앞에서는 됐는데 뒤에서는 안될 수도~ 이럴경우 트랜젝션(한번의 사건을 통해 여러개의 cud 작업이 일어날 때)~~ 
				//dto = new BoardDTO(num, writer, title, content, writeday, readcnt+1, 0,0,0);
				
				//readCnt 증가시키기 db에 반영하는건 뒤에서 작업하겠다! 
				//increaseReadCnt(conn) 원래계획~~ 
				
				isOk = true; //트랜젝션 (2)모든 작업이 정상적~ 
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {  //트랜젝션(3-2) jdbc 에서는 autocommit 이라 rollback 안됨! ->auto commit 해제시키기!! 
				//트랜젝션(3-1)
				if(isOk) { //try 마지막까지 잘 돼었으면
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			closeAll(rs, pstmt, conn);
		}
		return dto;
	}
	
	//readCnt 증가시키는 메서드!! 
	private int creatReadCnt(Connection conn, int num) {
		PreparedStatement pstmt = null;
		String sql = "update board set readcnt = readcnt + 1 where num = ?";		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
		return 0;
	}
	
	//updateUI
	public BoardDTO updateUI(int num) {
		BoardDTO dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from board where num = ?";
		ResultSet rs = null;
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String writer = rs.getString("writer");  // 나중에 회원기능과 합쳐지면writer 못바꾸게!!! 
				String title = rs.getString("title");
				String content = rs.getString("content");
				//reply method에서 사용하기위해 수정함. 
				int repRoot = rs.getInt("repRoot");  
				int repStep = rs.getInt("repStep");
				int repIndent = rs.getInt("repIndent");
				
				dto = new BoardDTO(num, writer, title, content, null, 0, repRoot, repStep, repIndent);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, pstmt, conn);
		}
		//return read(num); 이렇게 하면 안되는 이유: 조회수가 증가하기 때문!! 
		return dto;
	}
	
	//update
	public void update(BoardDTO boardDTO) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update board set writer = ?, title = ?, content = ? where num = ? ";		
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getTitle());
			pstmt.setString(3, boardDTO.getContent());
			pstmt.setInt(4, boardDTO.getNum());
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	//delete
	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from board where num = ?";

		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, conn);
		}
	}
	
	//reply
	public void reply(int orgnum, BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into board (num, writer,title, content, repRoot, repStep, repIndent) values (?,?,?,?,?,?,?)";
		boolean isOk = false;
		try {
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			int num = createNum(conn);
			
			BoardDTO orgDTO = updateUI(orgnum);
			
			// conn 같아야 transaction 적용된다!! 
			stepPlus1(conn, orgDTO);
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setInt(5, orgDTO.getRepRoot());
			pstmt.setInt(6, orgDTO.getRepStep()+1);
			pstmt.setInt(7, orgDTO.getRepIndent()+1);
			pstmt.executeUpdate();
			
			isOk = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(isOk) {
					conn.commit();
				} else {
					conn.rollback();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			closeAll(null, pstmt, conn);
		}
	}
	//stepPlus1
	//repRoot 값이 같은 다른 답글이 있는지 확인부모글의 repSetp 값보다 큰 repSetp 값을 갖고있는 답글의 repSetp 값을 변경시켜줌: repStep + 1
	private void stepPlus1(Connection conn, BoardDTO orgDTO) {
		PreparedStatement pstmt = null;
		String sql = "update board set repStep = repStep+1 where repRoot = ? and repStep > ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, orgDTO.getRepRoot());
			pstmt.setInt(2, orgDTO.getRepStep());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pstmt, null);
		}
	}
	

		
		
	
	
	

}
