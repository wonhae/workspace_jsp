package com.naver;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UploadServlet
 */

public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		File uploadFolder = new File("C:" + File.separator + "upload");
		if(!uploadFolder.exists()) {
			uploadFolder.mkdir();
		}
		
		String title = "";	
		String fileName = "";  //시스템에서관리해주는 것... cosjar에서 만들어준 rename system이용해 파일 중복 방지하기위한 새로운 이름! 
		String orgFileName = "";
	
		
		//cos.jar에 붙어있는 클래스 . 객체를 만드는 순간 파일 업로드는 끝났다. //10메가 최대 , 이름이 다르면 숫자 붙여서 처리해주는것
		MultipartRequest multi = new MultipartRequest(request, 
														"C:" + File.separator + "upload", 
														10*1024*1024, 
														"utf-8", 
														new DefaultFileRenamePolicy()); 
		
		
		title =  multi.getParameter("title");
		fileName = multi.getFilesystemName("file1");  //첨부파일의 이름 file 시스템에서 관리하는 데이터 !! 
		orgFileName = multi.getOriginalFileName("file1");  //사용자에게 보여지는 데이터 
		
		//2개다 가지고 가는 방법. query 형태로 붙여넣거나(파라미터), 데이터 바인딩
		request.setAttribute("fileName", fileName);
		request.setAttribute("orgFileName", orgFileName);
		
		System.out.println(title);
		System.out.println(fileName); 
		System.out.println(orgFileName);
		
		request.getRequestDispatcher("check.jsp").forward(request, response); //업로드 한 것 확인할 수 있게. 
	}

}
