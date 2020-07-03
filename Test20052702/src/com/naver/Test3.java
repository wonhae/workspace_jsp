package com.naver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test3
 */
@WebServlet("/test3")
public class Test3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//servlet context 객체를 획득해옴
		ServletContext application = getServletContext();  //application scope=프로젝트 전체
		
		//안쓰는 코드 
		application.setAttribute("hello", "hello");  //data binding
		
		//안쓰는 코드  // 일반적으로 이렇게는 안씀 application에는 방문자수만 ~
		List<StringBuffer> list = new ArrayList<StringBuffer>();
		list.add(new StringBuffer("good"));
		list.add(new StringBuffer("morning"));
		application.setAttribute("list", list);
		
		Integer icount = (Integer) application.getAttribute("count");  //방문자수
		if(icount == null) {  //최초방문시 icount == null
			icount = 1;
			application.setAttribute("count", icount);  //appli에 저장한다. 
		} else {
			application.setAttribute("count", icount+1);
		}
		
		request.getRequestDispatcher("NewFile.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
