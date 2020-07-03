package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//2
		///LoginDTO loginDto = new LoginDTO(id, pw);  -> new LoginDTO(id,pw)에다가 다 넣어도됨!! 우리는  db를 들리니까 new LoginDTO 여러번 생성해도 똑같다. 
		boolean isLogin = new MemberDAO().login(new LoginDTO(id,pw));
		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("login", new LoginDTO(id,null));  //그냥  "login","id" 만 넣어줘도 되지만, 한번도  new Login 만드는 이유는 감추어주기 위해서! //급식판.... 
			return new CommandAction(true, "select.bo");  //session에 바인딩 되어있기 때문엥 redirect 로 해도 데이트 살아있음. 
		} else {
			return new CommandAction(true, "loginui.bo");
		}
		
		
		
	}

}
