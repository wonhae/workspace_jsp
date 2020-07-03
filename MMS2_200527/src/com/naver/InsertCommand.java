package com.naver;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.dao.MemberDAO;
import kr.co.domain.MemberDTO;

public class InsertCommand implements Command {
	@Override
	public CommandAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 
		String id = request.getParameter("id");
	
		String name = request.getParameter("name");
		String sAge = request.getParameter("age");
		int age  =0;
		if (sAge != null) {
			age = Integer.valueOf(sAge);			
		}
		
		//2
		MemberDAO dao = new MemberDAO();
		dao.inseret(new MemberDTO(id, name, age));
		
		//3은 필요없다		
		
		//4 회원 목록으로 갈것!! 양식에 데이터가 있는 곳으로 간다! 데이터는 db로 (데이터 가진건 dao>command>servlet 생각)select.do or select.jsp로 가야할지??
		return new CommandAction(true, "select.do");
		//response.sendRedirect("select.do");
	}
}
