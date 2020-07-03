package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dto.MemberDTO;

public class InsertCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age = 0;
		if (sAge != null) {
			age = Integer.parseInt(sAge);
		}
		
		MemberDTO dto = new MemberDTO(id, name, age);
		MemberDAO dao = new MemberDAO();
		dao.insert(dto); //저장된다~~~~ 
		
//		command 가 void라서 각각에서 forward 구현한다! 나중에 팀플할때는 servlet 에서 일관적으로 포워딩 작업함
		//회원 목록으로 가봅시다
		//servlet 갔다오면 데이터를 가져와서 jsp양식에 뿌려줘야함. db에 먼저간다 = servlet에 먼저간다. 
		response.sendRedirect("select");  //select servlet으로간다!  //나중에 할때는 list 라고 해줌(목록)
		//어떤 방식일까??
		
	}
}
