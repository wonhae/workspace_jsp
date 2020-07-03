<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="test6" method="get">
		당신의 취미는? <br>  <!--같은 항목에 대해서는 똑같은 h 써줘야 된다/ 다르게 쓰면 다른 체크박스  -->
		<input type="checkbox" name="h" value="soccer"> 축구 <br>
		<input type="checkbox" name="h" value="baseball"> 야구<br>
		<input type="checkbox" name="h" value="baseketball"> 농구<br>
		<input type="submit" value="Get방식">
	</form>
	<!-- 학력같은건 라디오 버튼으로..라디오 버튼은 그냥 하던대로 -->
	<br>
	<form action="test6">
		<input type="radio" name="school" values="초등학교"> 초등학교<br>
		<input type="radio" name="school" values="고등학교"> 고등학교<br>
	</form>
	
	<form action="test3" method="Post">
		<input type="submit" value="Post방식">
	</form>

</body>
</html>