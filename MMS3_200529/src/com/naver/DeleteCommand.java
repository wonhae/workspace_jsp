package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DeleteCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		
		//로그인 되어있는지 확인할 것. 회원과 로그인이된 사람이 같은 사람인지 확인하기. m001이 로그인 되어있으면 m002는 삭제되게 하면 안된다.삭제와 동시에 로그아웃도 
		if (session != null) {
			
			LoginDTO loginDTO =  (LoginDTO) session.getAttribute("login");
			
			if (loginDTO != null) {  //로그인되어있다.  다른사람 이름으로 로그인 되어있을 수 있다. 
				//1
				String id = request.getParameter("id"); // jsp 창에서 넘겨받은 id를 가져온다. 
				
				if(loginDTO.getId().equals(id)) {  // 현재 로그인은 m001이 되어있다. 상황: delete.bo?id=m001  or m003 
					//2
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					session.invalidate();
					return new CommandAction(true, "select.bo");
				} else {//삭제하려는 아이디로 로그인해라
					return new CommandAction(true, "login.bo");
				}
				
			} else { //로그인하고 삭제해라
				return new CommandAction(true, "login.bo");
			}
			
		} else { //로그인 하고 삭제해라
			return new CommandAction(true, "login.bo");
		}
		
		
		
	}

}
