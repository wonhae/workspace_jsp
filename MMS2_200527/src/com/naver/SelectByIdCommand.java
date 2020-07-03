package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class SelectByIdCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		String id = request.getParameter("id");
		
		//2
		MemberDAO dao = new MemberDAO();		
		MemberDTO dto = dao.selectById(id);  //1개밖에 안넘겨받음 ~~ 
		
		//3
		request.setAttribute("dto", dto);
		//4 데이터 온전하게 유지해야함. selectById.jsp 로 가서 request.setAttribute("dto", dto);를 뿌려줌
		//request.getRequestDispatcher("selectById.jsp").forward(request, response);
		return new CommandAction(false, "selectById.jsp");

	}

}
