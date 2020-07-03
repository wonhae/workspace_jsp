package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//나중엔 commandaction이라는 클래스(포워딩 관련)
	CommandAction execute(HttpServletRequest request, HttpServletResponse response) 
					throws ServletException, IOException;
	
	
	
	
}
