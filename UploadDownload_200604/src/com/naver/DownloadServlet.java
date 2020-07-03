package com.naver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("fileName"); //소문자로 해도 되긴 하는뎅
		String uploadPath = "C:" + File.separator + "upload";  //실제로는 WebContent 안에 별도의 폴더를 만든다.  
		//String uploadPath = request.getServletContext().getRealPath("img");  //img 의 절대 좌표 알아냄  실제론 이렇게 하기! 
		String filePath = uploadPath +File.separator+ fileName;
		File f = new File(filePath);  //이거얻으려고 위의 작업 한다. 
		
		//파일의 정체 알았으니 스트림 만들다아 
		InputStream in = null;	
		try {
			in = new FileInputStream(f); //우리가 만든 자원!!! 반드시 닫아줘야한다. 
			//여기까지 업로드한 파일 준비함
			
			//다운로드 환경설정!!여기부터 
			//outputstream 만들지 않고 시스템에서 제공해준 것 사용한다. 
			//mime type
			String sMimeType = getServletContext().getMimeType(filePath);  //filePath의  mimetype 확인!
			if(sMimeType == null) {
				sMimeType = "application/octet-stream"; //마인타입이 지정되지 않았을때(=어떤 타입인지 모를 때)그냥 다운 받으세요~ 라는 뜻. 
			}
			response.setContentType(sMimeType);
			
			String encoding = new String(fileName.getBytes("utf-8"),"8859_1"); //이쪽에서 utf-8로 보내줬어도 브라우저에서 깨질 수 있다.브라우저(8859_1)에 맞춰서 인코딩 방식 수정 
			response.setHeader("Content-Disposition", "attachment;filename="+encoding); // key,value
			//위에까지 다운로드 위한 환경설정 한 것 ! 
			
			//스트림 이용하여~~ 
			ServletOutputStream out = response.getOutputStream();  //우리가 직접 생성한게 아님. 콘테이너가 가지고 있는걸 우리가 가져다 사용. 콘테이너의 자원 함부로 close 하면 안된다. 
			//여기까지 스트림 2개 형성했음
			byte[] arr = new byte[1024];
			
			int leng = -1; //몇개를 넘겨받았는지 배열에 넣을 수 있는 변수가 필요
			while(true) {
				leng = in.read(arr, 0, arr.length);  //몇개 받았냐! 이걸 변수에 넣어줌
				if(leng == -1) break;
				out.write(arr, 0, leng); //arr에서 받아오는데 0 부터 leng개 까지 가져옴
			}
			out.flush(); //bytestream으로 작업해서 이거 안쓰도 되지만~ 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) in.close();				
			} catch (Exception e2) {
				e2.printStackTrace();
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
