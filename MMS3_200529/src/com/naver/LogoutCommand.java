package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//session에 클라이언트가 넘겨준 데이터 들어있음. 
		//1
		HttpSession session = request.getSession(false);
		
		if(session != null) {  ////세션이 널일 경우...로그인이 안되어있을 경우??
			LoginDTO login = (LoginDTO) session.getAttribute("login");  /////만약 logincommand에서 setatt할때 ("login",id) 로만 했으면 loginDTO로 못받지 않나??
			if(login != null) {
				session.invalidate();
				//return new CommandAction(true, "select.bo");
			} //else { //세션에 데이터 바인딩이 안되어있음
				//return new CommandAction(true, "select.bo");
			//}
			
			
		} //else {
			//return new CommandAction(true, "select.bo");
		//}
		
		
		return new CommandAction(true, "select.bo");
		
		
	}

}
