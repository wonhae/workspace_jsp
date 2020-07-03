package com.naver;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test5Servlet
 */
@WebServlet("*.do") //확장자형 하면 doget,dopost 코드 같아진다.  xxxx.do로끝나는건 다 이 서블릿으로 들어옴
public class Test5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //post방식으로 들어왔을때!!! //get방식으로할때는 server.xml에 써놨다! 
		response.setContentType("text/html;charset=utf-8");
		
		System.out.println(".do로 끝나는 요청은 모두 이 서블릿으로 들어온다");
		//servlet Path 가져오는 방법(client가  요구하는게 뭔지 알아내기)
		//방법1 
		String sp = request.getServletPath();  //client가 요구한게 뭔지 알수 있다.  //실무에서 안쓴다. 만들어진지 얼마 안되어서 
		System.out.println(sp);
		//방법 2 실무
		String uri = request.getRequestURI();   //System.out.println(uri);   //Test20052701/xxx.test5
		String ctx = request.getContextPath();  //System.out.println(ctx);  //  Test20052701   =Context
		String s = uri.substring(ctx.length()); //substring
		if(s.equalsIgnoreCase("/insert.do")) {
			System.out.println("입력입니다");
		} else if(sp.equalsIgnoreCase("/select.do")){
			System.out.println("조회입니다");
		} else if(sp.equalsIgnoreCase("/update.do")){
			System.out.println("수정입니다");
		}
		request.getRequestURI();
		request.getContextPath();
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
