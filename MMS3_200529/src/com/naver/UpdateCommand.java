package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if(sAge != null) age = Integer.parseInt(sAge);
			
		//2
		 new MemberDAO().update(new MemberDTO(id, pw, name, age));
		
		
		//4 회원정보 자세히 보기로 갈 것
		return new CommandAction(true, "selectById.bo?id="+id);
	}

}
