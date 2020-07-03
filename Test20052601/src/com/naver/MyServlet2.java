package com.naver;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/ms2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글안깨지게 하는것 2가지 방식 
		response.setContentType("text/html;charset=utf-8");
		//client->server
		String name= request.getParameter("name");
//		id="tt";
		String sAge = request.getParameter("age");
		int age= 0;
		if (sAge !=null) {
			age = Integer.parseInt(sAge);
		}//블럭잡고 우클릭. if문으로 감싸기 
		
		PrintWriter out= response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(name);
		out.print(age);
		out.print("</body>");
		out.print("</html>");
		//이상태에서 500에러 코드상으로는 이상 없다. 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 안깨지게 
		request.setCharacterEncoding("utf-8");
		
		response.setContentType("text/html;charset=utf-8");
		String id = request.getParameter("id");
		System.out.println(id);
		String pw = request.getParameter("pw");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print(id);
		out.print("<br>");
		out.print(pw);
		out.print("</body>");
		out.print("</html>");
		
	}

}
