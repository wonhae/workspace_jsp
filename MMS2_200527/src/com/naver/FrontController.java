package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")  //get post 방식 코드 똑같다. 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//사용자가 원하는 것 추출
		String uri = request.getRequestURI();
		String ctxp = request.getContextPath();
		String sp = uri.substring(ctxp.length());
		
		Command com = null;
		if(sp.equalsIgnoreCase("/insertui.do")) { /////
			com = new InsertUICommand();
		} else if(sp.equalsIgnoreCase("/insert.do")) {
			com = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/select.do")) {
			com = new SelectCommand();
		} else if(sp.equalsIgnoreCase("/selectById.do")) {
			com = new SelectByIdCommand();
		} else if(sp.equalsIgnoreCase("/updateui.do")) {
			com = new UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/update.do")) {
			com = new UpdateCommand();
		} else if(sp.equalsIgnoreCase("/delete.do")) {
			com = new DeleteCommand();
		} else if(sp.equalsIgnoreCase("/loginui.do")) {
			com = new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/login.do")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/logout.do")) {
			com = new LogoutCommand();
		} 
		
		/*
		 * if (com != null) { com.execute(request, response); }
		 */
		
		//포워딩 구현할 것 
		if (com != null) {
			CommandAction action = com.execute(request, response);
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request, response);
			}
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
