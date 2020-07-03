package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//command action 나중에 회원관리할때는 //오늘은 void
	void execute(HttpServletRequest request, 
				HttpServletResponse response)
						throws ServletException,IOException;
	
	
}
