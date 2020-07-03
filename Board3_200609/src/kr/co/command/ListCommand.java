package kr.co.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.BoardDTO;
import kr.co.domain.CommandAction;

public class ListCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//나중에 페이징 처리된 것 넘어온다. 지금은 받을 것 없다. 
		
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.list();  //나중에 list의 파라미터 있을 것이다. 
		
		request.setAttribute("list", list);
				
				
		return new CommandAction(false, "list.jsp");
	}

}
