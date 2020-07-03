package com.naver;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//1. 클라이언트가 보내준 데이터 획득 및 가공
		//2. DAO 객체 생성 및 해당 메서드 호출
		//3. 데이터바인딩(pageContext,request,session,application)
		//4. forwarding 작업
		
		//2
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> list =  dao.selectAll();  //받은 데이터는 jsp에서! 가능하게 하려면 데이터 바인딩!
		
		//3 
		request.setAttribute("list", list);  //databinding 했으면 -> distpatcher 방식으로! 
		
		//4
		return new CommandAction(false, "select.jsp");
	}
}
