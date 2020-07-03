package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class hw
 */
@WebServlet("/hw")
public class hw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hw() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String id= request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age= Integer.parseInt(sAge);
		
		
		PrintWriter out=  response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(id);
		out.print(name);
		out.print(age);
		out.print("</body>");
		out.print("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id= request.getParameter("id");
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age= Integer.parseInt(sAge);
		
		
		PrintWriter out=  response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(id);
		out.print(name);
		out.print(age);
		out.print("</body>");
		out.print("</html>");
		
	}

}
