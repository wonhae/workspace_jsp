package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class UpdateUICommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정될 화면 먼저 나오게 name,age만 update 
		//1 보내준 데이터가 있다. 
		String id = request.getParameter("id");
		
		//2
		MemberDAO dao = new MemberDAO();		
		MemberDTO dto = dao.updateUI(id);  //selectById 그대로 사용 해도 좋으나. class UpdateUICommand 이므로 updateUi로 바꾼다. 간단히 메소드 만들기
		
		//3
		request.setAttribute("dto", dto);
		
		//4
		//request.getRequestDispatcher("update.jsp").forward(request, response);
		return new CommandAction(false, "update.jsp"); //포워딩 코드를 포워딩 정보코드로 교체!! 
		
	}
}
