package z.on;

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
 * Servlet implementation class ZUPloadServelet
 */
@WebServlet("/upload")
public class ZUPloadServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZUPloadServelet() {
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
	
		File uploadFolder = new File("c:" + File.separator + "upload");
		if(!uploadFolder.exists()) { uploadFolder.mkdir(); }
		
		String title = ""; 
		String fileName = "";
		String orgName = "";
		
		MultipartRequest multi = new MultipartRequest(request, "c:" + File.separator + "upload", 10*1024*1024, "utf-8", new DefaultFileRenamePolicy());
		
		title =  multi.getParameter("title");
		fileName = multi.getFilesystemName("addFile");
		orgName = multi.getOriginalFileName("addFile");
		
		request.setAttribute("fileName", fileName);
		request.setAttribute("orgName", orgName);
		
		request.getRequestDispatcher("ZCheck.jsp").forward(request, response);
		
		
		
		
		
		
		
		
	}

}
