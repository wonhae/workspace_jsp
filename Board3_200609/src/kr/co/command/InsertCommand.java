package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class InsertCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		BoardDAO dao = new BoardDAO();
		
		dao.insert(new BoardDTO(-1, writer, title, content, null, 0, 0, 0, 0)); //원글이니까 다 0 
//			for (int i = 0; i < 100; i++) {  //너무 빨라서 잼이 걸림 
//				dao.insert(new BoardDTO(-1, "writer"+i, "title" + i, "content"+i, null, 0, 0, 0, 0)); //원글이니까 다 0    //// "writer" 따옴표 써주는이유..
//				
//				try {
//					Thread.sleep(50);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			} 
			
		return new CommandAction(true, "list.do");
	}

}
