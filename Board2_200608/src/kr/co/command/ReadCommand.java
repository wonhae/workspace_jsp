package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class ReadCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//num을 넘겨받고, 게시글 하나에 대한 온전한 데이터를 다 받아와양한다. 
		String snum = request.getParameter("num"); //클라이언트가 보내준 데이터는 다 스트링형! 
		int num = -1;
		if(snum != null) {
			num = Integer.parseInt(snum);
		}
		
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.read(num);
		
		request.setAttribute("dto", dto);
		
		return new CommandAction(false, "read.jsp");
	}

}
