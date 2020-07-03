<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--서버로 보내고 싶으몀 name 속성으로 써주고 ="파라미터 네임 정의"  -->
	<form action="ms2" method="post">
		ID : <input name ="id"><br>  
		PW : <input name ="pw"><br>
		<input type="submit" value="로그인">
	
	</form>


	<hr>
	<form action="ms2" method="get">
		name: <input name="name"><br>
		age : <input name="age"><br>
		<input type="submit" value="click">		
	</form>
	
	
</body>
</html>