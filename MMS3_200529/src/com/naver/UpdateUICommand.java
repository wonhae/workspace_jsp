package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1
		String id = request.getParameter("id");
		
		//2
//		MemberDAO dao = new MemberDAO();
//		MemberDTO dto = dao.updateUI(id);
		MemberDTO dto = new MemberDAO().updateUI(id);
		
		//3
		request.setAttribute("dto", dto);
		//4
		return new CommandAction(false, "update.jsp");
	}

}
