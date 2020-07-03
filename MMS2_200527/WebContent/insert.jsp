<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 양식</h1>
	<form action="insert.do" method="post"> 
		ID : <input name = "id"><br>
		Name : <input name = "name"><br>
		Age : <input type = "number" name = "age" > <br>
		<input type = "submit" value = "가입">
	</form>

	<!-- html 주석 -->
	<%--  <!-- ${}jsp 는 html 주석으로 안된다 --> --%>
	<%-- jsp의 주석이다 --%>

</body>
</html>