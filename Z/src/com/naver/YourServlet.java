package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class YourServlet
 */
@WebServlet("/yourss")
public class YourServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    					HttpServletResponse response)
    						throws ServletException, IOException {
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out= response.getWriter();
    	out.print("<html>");
    	out.print("<body>");
    	out.print("hi");
    	out.print("안냐세요");
    	out.print("</body>");
    	out.print("</html>");
    }
    
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out= response.getWriter();
		out.print("<html>");
    	out.print("<body>");
    	out.print("dopost");
    	out.print("<hr>");
    	out.print("이건 두포스트 ");
    	out.print("</body>");
    	out.print("</html>");
	}

}
