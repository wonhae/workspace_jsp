package com.naver;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */

public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
							throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  //한글 데이터가 들어올 수 있다. 
		response.setContentType("text/html;charset=utf-8");  //혹시 응답한다면 한글데이터로 
		//클라이언트가 보내준 데이터 다 넘겨받았다. 
		String id= request.getParameter("id0");
		String name= request.getParameter("name0");
		String sAge= request.getParameter("age0");
		int age = 0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);
		}
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		//인터넷 창 확인은 select.jsp에서 할 것 
		
		//포워딩 작업 해봄  //select servlet -> db 각져와서 ->select.jsp 로 넘어감
//		RequestDispatcher dis = request.getRequestDispatcher("select");
//		dis.forward(request, response);
		//redirect 방식
		response.sendRedirect("select");  //select는 url 패턴값 
		
		//이 다음에 crud 서술
	}

}
