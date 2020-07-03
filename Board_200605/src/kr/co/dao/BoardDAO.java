package kr.co.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	
	

}
