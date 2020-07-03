package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class SelectCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 클라이언트가 보내준 것 없다. 
		//2
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list = dao.selectAll();
		
		//3 select.jsp (View)에다가 데이터 뿌려주기위헤 데이터 바인딩/ 어떤객체?  request! 
		request.setAttribute("list", list);  // redirect 방식으로 forward 하면 안된다!! 
		
		//4 
		//request.getRequestDispatcher("select.jsp").forward(request, response);
		return new CommandAction(false, "select.jsp");
	}
}
