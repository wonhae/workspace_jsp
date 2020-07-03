<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="yours" method="post">
		<input type="submit" value="click">
	</form>
	
	현재시간은 4시 47분
	<%
		Date d = new Date();
		out.print(d.toLocaleString());
	%>
</body>
</html>