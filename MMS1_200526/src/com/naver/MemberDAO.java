package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.co.dto.MemberDTO;

public class MemberDAO {
	//이미만들어진 커넥션 풀 사용하려면 그것과 똑같은 게 있어야 한다. 
	//javax.sql 사용
	private DataSource dataFactory;  //커넥션풀
	
	//JNDI 사용해 dataFactory 만들어냄 :연결(Mapping)작업
	///java or javax만 쓴다  //자료형이 자식ㅡ 생성자는 부모일경우 다형헝 안된다.  자료형이 부모, 생성자는 자식일 경우 다형성
	public MemberDAO() {  
		try {
			Context ctx = new InitialContext();
			dataFactory = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle11g");  //context.xml의 name 값 
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//delete
	public void delete(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from member where id = ?";
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	//update
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update member name = ?, age = ? where id = ?";
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2,dto.getAge());
			pstmt.setString(3, dto.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//select
	public List<MemberDTO> selectAll(){
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "select * from member";
		ResultSet rs = null;
		
		try {
			conn = dataFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				
				MemberDTO dto = new MemberDTO(id, name, age);
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	//insert
	public void insert(MemberDTO dto) {  //connectioin ->java.sql
		Connection conn = null;
		PreparedStatement pstmt= null;
		String sql = "inset into member (id,name,age) values (?,?,?)";
		
		//트렌젝션 상황: 하나의 사건에 대해서 여러개의 사건(cud)작업이 발생하는것
		boolean isOk = false;
		try {
			//conn = DriverManager.getConnection(url, user, password) 예전
			conn = dataFactory.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getAge());
			pstmt.executeUpdate();
			
			isOk=true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				try {
					if(isOk) {conn.commit();} else {conn.rollback();}
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();  //커넥션 제거가 아니라 반환 
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
}
