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
	out.print("hello");
	
	%>
	<%="hello"%>
	<%
	out.print("<h1>Hello</h1>");
	%>
	
	<h1><%="hello"%></h1>
	
	<%
		request.setAttribute("name", "kim");
	%>
		${name}<br>
	<%
		for(int i = 0; i < 10 ; i ++) {
			pageContext.setAttribute("i", i);
	%>
	
			${i}<br>
	<%
		}
	%>		
	<%! public void me1(){ 
		System.out.print("hhh");
	}
		
	
	public int me2(){return 2;}  %>
	<%= me2() %>
	
</body>
</html>