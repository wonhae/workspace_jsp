package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class selectCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1. client 가 보내준 데이터 획득 및 가공(나이-스트링)
		//2. DAO객체 생성 및 해당 메소드 호출
		//3. jsp(View:보여주는 양식)에 뿌려줄 데이터 바인딩  
		//4. forwarding 작업
		
		//2.
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
//		int age = 3;
		
		//3. 
		//로그인은 세션에 저장(데이터바인딩). 나머지는 다 request에 데이터를 바인딩한다. =저장한다 //response에는 데이터 저장못한다.  //or context에 저장?
		request.setAttribute("list", list); //setAttribute이건 주소 바뀌면 안됨 redirect 하면 안됨!! dispatcher로 해야함!! ->나중 설명 별도
		//일반적으로 키 벨류 똑같이 넣어줌 헷갈리니까  이게다르면 문서작업 해줘야함 //list 라는 이름으로 저장한 것
//		request.setAttribute("age", age);
		
		//4. 디스패쳐방식
		RequestDispatcher dis = request.getRequestDispatcher("select.jsp");
		dis.forward(request, response);

	}

}
