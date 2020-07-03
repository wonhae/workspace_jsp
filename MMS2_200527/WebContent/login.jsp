<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session = "false" %>  <!-- 세션 defaul 값 = true -->
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<h1>로그인 화면</h1>
	<!-- 세션이 있어야할 때 없어야 할 때 구별해야. 로그인 된 상태에서 계좌이체 가능하게 만들어야 -->
	<form action="login.do" method = "post">
		ID : <input name = "id" ><br>
		PW : <input name = "pw" type = "password"><br>
		<input type = "submit" value = "로그인" >
	</form>

</body>
</html>