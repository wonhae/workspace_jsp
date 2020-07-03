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
	<!-- 클라이언트가 보내준 data id,name,age -->
	<form action="update.do" method = "post">  <!-- 실제로 수정하는 곳으로 간다 action -->
		ID: <input name = "id" value = "${dto.id}" readonly ><br> <!-- el : expression language --> 
		Name : <input name = "name" value = "${dto.name}"><br>  <!-- dto.get 메소드 내부적으로 후출됨  -->
		Age : <input type = "number" name = "age" value = "${dto.age}"><br>
		
		<input type = "submit" value = "수정">
	</form>

</body>
</html>