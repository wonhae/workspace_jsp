package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//2
		MemberDAO dao = new MemberDAO();
		boolean login = dao.login(new LoginDTO(id, pw));
	
		
		//3 세션만들기 request.getSession(); = request.getSession(true);  //세션이 없으면 만들어서라도 넘겨줘. 무조건 세션 생김 
		  //request.getSession(false);  : 로그인 이후 작업! 
		
		
		if(login) {
			HttpSession session = request.getSession(); //login이후에만 session 객체 만들기!   (세션은 내장..)
			session.setMaxInactiveInterval(60); //단위는 초!(servers>xml 에서 단위는 분)   세션 유지됨
			session.setAttribute("login", new LoginDTO(id, null));  //세션이 있다고 로그인되는게 아니라 세션에 바인딩되어있는 값이있느냐의 여부 확인이 중요! 
			//response.sendRedirect("select.do");
			return new CommandAction(true, "select.do");
		} else {  //로그인 실패 시 
			//response.sendRedirect("loginui.do");
			return new CommandAction(true, "loginui.do");
		}
		
		
		
		
	}

}
