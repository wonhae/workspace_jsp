<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<jsp:useBean id="login" class="com.naver.LoginBean"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		login.setId("m002");
		login.setPw("1");
		
		pageContext.setAttribute("login", login);
	
	%>
	<%=login.getId()%> : <%= login.getPw() %>
	<hr>
	${login.id} : ${login.pw}
	
</body>
</html>