package kr.co.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.domain.CommandAction;

public class ReplyUICommand implements Command {

	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String num = request.getParameter("num");  //문자열의 더하기 연산
		//*문자열의 더하기 연산  1+1=2     "hello" + " world" = "hello world"   "hello" + 119 = "hello119" 문자열+숫자 = 문자열!!!!! 
		
		return new CommandAction(false, "reply.jsp?num="+num);  //2가지방법 : request 에 바인디하는 방법, 주소에다가 직접 타이핑하는방법 
	}

}
