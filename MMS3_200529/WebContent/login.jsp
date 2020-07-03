<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false" %> <!-- session false -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 화면</h1>
	<form action="login.bo" method = "post">
		ID : <input name = "id"> <br>
		PASSWORD : <input name = "pw"> <br>
		<input type = "submit" value = "로그인" >
	</form>

</body>
</html>