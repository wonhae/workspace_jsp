package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.dao.MemberDAO;
import kr.co.domain.LoginDTO;

public class DeleteCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1
		String id = request.getParameter("id");
		
		
		//로그인 된 후에 삭제할 수 있도록
		//로그인을 한 후에 

		HttpSession session = request.getSession(false);
		
		
		if(session != null) {  //1. session이 널이 아니면 로그인이 되어있을때일 가능성이 크다 
			
			LoginDTO loginDTO = (LoginDTO) session.getAttribute("login");	//2. 세션에서 데이터 가져옴 
			
			if(loginDTO != null) {  //3. 로그인 dto 가 있으면 로그인이 되어있을 가능성이 크다(다른사람걸로 로그인돼어잇을 가능성 있음)  ->(1)해당회원 로그인 (2)다른회원이 로그인
				
				if (loginDTO.getId().equals(id)) { //4. 내가 로그인 했냐?
					MemberDAO dao = new MemberDAO();
					dao.delete(id);
					session.invalidate(); //회원정보 삭제후 로그아웃 시키기
					//response.sendRedirect("select.do");  //포
					return new CommandAction(true, "select.do");
				} else {
					return new CommandAction(true, "loginui.do");
					//response.sendRedirect("loginui.do"); //4 
				}
				
				
			} else {
				return new CommandAction(true, "loginui.do");
				//response.sendRedirect("loginui.do");  //3. session.dto  remove attribute
			}
			
		}else {
		return new CommandAction(true, "loginui.do");
		//response.sendRedirect("loginui.do");  //1. 로그인안됐으면 로그인하고와 
		}
		
		
		
		
		
	}
}
