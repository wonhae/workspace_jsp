package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그아웃해주기
		HttpSession session = request.getSession(false); //세션 있으면 넘겨주고 없으면  null 값 넘겨줘!!  //request.getSession(); : 세션 있으면 넘겨주고 없으면 만들어줘
		if(session != null) {
			//3 가지 방법
			//1 session.setMaxInactiveInterval(1);//1초후 로그아웃
			//2 session.removeAttribute("login"); 
			//3 
			session.invalidate();
		}
		
		//response.sendRedirect("select.do");
		return new CommandAction(true, "select.do");
		
		//4
		
		
	}

}
