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
	<form action="insert.bo" method = "post">
		ID : <input name = "id"> <br>      <!-- 중복체크 : 새로운창 or 에이작스??   -->
		PASSWORD : <input name = "pw" type = "password"> <br>     <!-- 비밀번호는 2개.. 스크립트에서 2개 확인..  -->
		NAME : <input name = "name" > <br>
		AGE : <input name = "age" type = "number" > <br>
		<input type = "submit" value = "회원 가입">
	</form>
	
	
</body>
</html>