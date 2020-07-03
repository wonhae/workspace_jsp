package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.BoardDAO;
import kr.co.domain.CommandAction;
import kr.co.domain.pageTO;

public class ListPageCommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String scurPage = request.getParameter("curPage");   //받아오는것 없으면 null~ 문제될게 없다. 
		int curPage = 1; //1page를 나오게하고싶다면 1을 넣어줘야  *초기화 값 잘 지정하기!!!(-1,0,1..) -1넣어준다:자기가 설정해준다는뜻 //처음엔 받아오는게 없으니까 1이다. ///받아오는게 없으면 에러 안뜨나??
		if(scurPage != null) {  //list.do로 접속했을 때!! 
			curPage = Integer.parseInt(scurPage);
		} 
		// int curPage=1 을 안써줄 것이면 뒤에 추가해주기  else { curPage =1} 
		
		BoardDAO dao = new BoardDAO();
		pageTO to = dao.page(curPage); //게시글이 몇개인줄알아야 페이징 처리 가능.... begin,end에 대한 정보필요 list<boarddto>로는 안된다. map사용하면되지만 보통 별도의  dto 만든다. 
		
		request.setAttribute("to", to);
		request.setAttribute("list", to.getList()); //list.do에 <c:forEach items="${list}" var="dto"> 사용하기위해서 //이 줄 코드 안쓰고 싶으면 list.do에가서 "${to.list}" 해야함! 
		
		return new CommandAction(false, "list.jsp");
	}

}
