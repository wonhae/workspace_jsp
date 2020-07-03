<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 정보 수정</h1>
	
	<form action="update.bo" method = "post">
		ID: <input name = "id" value = "${dto.id}" readonly> <br>
		PASSWORD : <input name = "pw" value = "password" required> <br>
		NAME : <input name = "name" value = "${dto.name}"> <br>
		AGE : <input name = "age" value = "${dto.age}"> <br>
		<input type = "submit" value = "회원 정보 수정">
	</form>
	
	
</body>
</html>