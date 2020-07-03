<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Expression Language(표현언어)</h1>
	${1123 }<br>
	${"hello" }<br>
	${1+2 }<br>
	${1*4 }<br>
	${1/2 }<br>
	${1%2 }<br>
	${1>2 }
	${1==2 }
	<hr>
	${true && true }<br>
	${(3>4) && (5<6) }<br>
	${true || false }
	<hr>
	${3>4?100:-5 }
	<%
	request.setAttribute("a", 11);
	%>
	<a href="${a>3? 'http://naver.com':'http://google.com'}">hello</a>
	
</body>
</html>