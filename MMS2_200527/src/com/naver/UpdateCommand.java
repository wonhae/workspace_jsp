package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateCommand implements Command{
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// servlet으로 가서 db 에 가서 수정할 수 있도록 
		//1
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if(sAge != null) {
			age = Integer.valueOf(sAge);
		}
			
		//2
		MemberDAO dao = new MemberDAO();
		dao.update(new MemberDTO(id, name, age));
		
		
		//4
		//response.sendRedirect("select.do");  //select.jsp는 껍데기만!! 데이터 가져가야하니까!! controller 들리기 
		return new CommandAction(true, "select.do");
	}
}
