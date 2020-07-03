<%@page import="kr.co.domain.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디로 검색해서 회원정보 자세히 보기</h1>
	<% 
		MemberDTO dto = (MemberDTO) request.getAttribute("dto");
	%>
	<!-- expression tag  =>화면에 출력한다 표현. < %= % > -->
	ID : <%= dto.getId() %>  el표기시 ${dto.id}  <br> 
	Name : <%= dto.getName() %><br>
	Age : <%= dto.getAge() %><br>
		
	<%-- ${}  el을 더 많이 사용할 것이다.--%>
	<a href="updateui.do?id=<%=dto.getId() %>">수정</a>  |  <a href = "delete.do?id=${dto.id}">삭제</a>   |  <a href="select.do">목록</a>

	<!-- selectById.do로 인터넷창에! .do 해야 db 들리니까!  -->
</body> 
</html>