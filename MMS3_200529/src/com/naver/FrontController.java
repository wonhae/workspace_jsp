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
@WebServlet("*.bo")
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
		request.setCharacterEncoding("utf-8");  //get방식에서는 안먹힌다. post 방식에서만 먹히지만, *.bo 이므로 둘다 쓰기
		response.setContentType("text/html;charset=utf-8");
		
		//servletpath 구하기
		String uri = request.getRequestURI();
		String ctxt = request.getContextPath();
		String sp = uri.substring(ctxt.length());
		
		//ualsIgnoreCase("/insertui.bo")) 빼고 싶으면 String sp = ctxt.substring(uri.length()+1);
		
		//switch case로 하면 더 코드가 간결해진다. 
		Command com = null;		
		if(sp.equalsIgnoreCase("/select.bo")) {
			com = new SelectCommand();
		} else if(sp.equalsIgnoreCase("/insertui.bo")) {
			com = new InsertUICommand();
		} else if(sp.equalsIgnoreCase("/insert.bo")) {
			com = new InsertCommand();
		} else if(sp.equalsIgnoreCase("/selectById.bo")) {
			com = new SelectByIdCommand();
		} else if(sp.equalsIgnoreCase("/updateui.bo")) {
			com = new UpdateUICommand();
		} else if(sp.equalsIgnoreCase("/update.bo")) {
			com = new UpdateCommand();
		} else if(sp.equalsIgnoreCase("/loginui.bo")) {
			com = new LoginUICommand();
		} else if(sp.equalsIgnoreCase("/login.bo")) {
			com = new LoginCommand();
		} else if(sp.equalsIgnoreCase("/logout.bo")) {
			com = new LogoutCommand();
		} else if(sp.equalsIgnoreCase("/delete.bo")) {
			com = new DeleteCommand();
		}
	
		else {
			System.out.println("제공하지 않는 서비스입니다.");
		} 
		
		
		//포워딩
		if(com != null) {
			CommandAction action = com.execute(request,response);  /////
			
			if(action.isRedirect()) {
				response.sendRedirect(action.getWhere());
			} else {
				request.getRequestDispatcher(action.getWhere()).forward(request,response);
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
