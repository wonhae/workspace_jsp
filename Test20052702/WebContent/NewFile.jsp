<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jsp 에서 자바 코드 쓰고싶으면 < % 안에 쓸 것. test3 출력해보세요 -->
	
 <%
 	/*application에 data binding 했다!  */
 	String hello = (String) application.getAttribute("hello");	
 	List<StringBuffer> list = (List<StringBuffer>) application.getAttribute("list");
 	Integer count = (Integer) application.getAttribute("count");  //int로 넘겨받음  ->int로 하면 안된다!    //autoboxinv, autounboxing
 	
 	out.print(count);
 	out.print(list);
 %>

	
</body>
</html>