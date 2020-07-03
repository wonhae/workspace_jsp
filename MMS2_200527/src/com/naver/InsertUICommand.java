package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertUICommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글쓰기 버튼 누르면 입력화면으로  이동!!!   글쓰기 화면 먼저 나온다. 
		
		//4. 포워딩만 해주면됨
		//request.getRequestDispatcher("insert.jsp").forward(request, response);  //redirect , dispatcher 둘다 ok 
		return new CommandAction(false, "insert.jsp");  
	}
}
