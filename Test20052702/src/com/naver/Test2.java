package com.naver;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test2
 */

public class Test2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//test1 초기화 파라미터 사용해봄  //null나옴
//		String dcn = getInitParameter("driverClassName");
//		String url = getInitParameter("url");
//		System.out.println(dcn);
//		System.out.println(url);
//		
		//servlet context  parameter 가져온다
		ServletContext application = getServletContext();  //변수명 application으로할 것!! 
		String un = application.getInitParameter("username");  
		String pw = application.getInitParameter("password");
		System.out.println(un);
		System.out.println(pw);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}