<%@page import="java.io.PrintWriter"%>
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
	<%
		PrintWriter out2 = response.getWriter();
		//out 이라고 하면 안된다. servlet 에서는 내장객체 익히기 위해 쓴것~~~ 
		out2.print("hello");
		out.print("hello");
	%>
	
	<%
		response.sendRedirect("NewFile8.jsp");
	%>
</body>
</html>