<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 화면</h1>
	<form action="insert" method="post">
	<!-- name 속성 (서버쪽으로 보내줄 때 파라미터의 네임값을 지정해주는 속성)파라미터 value: 사용자 입력
	// "id"이건 파라미터 네임 // action ->url pattern 입력 -->
	ID : <input name = "id0"><br>
	이름 : <input name = "name0"><br>
	나이: <input name = "age0"><br>
	<input type = "submit" value = "회원가입">
	
	</form>
</body>
</html>