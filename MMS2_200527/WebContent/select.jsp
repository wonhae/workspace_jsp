<%@page import="kr.co.domain.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      <!-- jstl  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--list에 있는 것 화면에 출력  -->
	<!-- 로그인이 비어있으면 로그인 글자 나오게, 아니면 로그인했으면 로그아웃 나오게  -->
	<a href = "${empty login ? 'loginui.do' : 'logout.do' }">${empty login ? '로그인'  : '로그아웃 '}</a> <br> 
	
	<!-- <a href ="loginui.do">로그인</a><br>  위에것 썼으면 이거 지우기  -->
	
	<a href="insertui.do">회원등록</a> <br>
	
	
	<a href = "loginAndDelete.do">삭제</a>  <!--로그인 되었을 시 삭제가능하도록  -->
	
	<h1>회원 목록 출력</h1>
	<!-- for(int x: arr){}   dto=x / arr{}=${list}-->
	<c:forEach items = "${list}" var = "dto">
		<a href = "selectById.do?id=${dto.id}">${dto.id} : ${dto.name}</a>
		<br>		
	</c:forEach>
	
	
	<%-- 	<%
		List<MemberDTO> list = (List<MemberDTO>) request.getAttribute("list");
		for(int i = 0; i < list.size(); i ++) {
			MemberDTO dto = list.get(i);
			/* 나중에 클릭할 수 있게 a 태그  */
			out.print("<a href = 'selectById.do?id=" + dto.getId()+ "'>");
			out.print(dto.getId());
			out.print(":");
			out.print(dto.getName());
			out.print("</a>");
			out.print("<br>");
		}
		
		/* select.do 에서 확인  */
		/* insertui.do 에서 확인  */
		%> --%>
	
</body>
</html>