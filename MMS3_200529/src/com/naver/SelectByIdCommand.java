package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1 
		String id = request.getParameter("id");
		
		//2
		MemberDAO dao = new MemberDAO();
		MemberDTO dto =  dao.selectById(id);
		
		//3
		request.setAttribute("dto", dto);
		
		//4		
		return new CommandAction(false, "selectById.jsp");
	}

}
