<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>수정 화면</h1>
	<form action="update.do" method="post">
		num : <input value="${dto.num}" name = "num" readonly ><br>
		작성자 : <input value ="${dto.writer}" name = "writer"><br>
		제목 : <input value="${dto.title}" name="title"><br> 
		내용 : <br>
		<textarea rows="5" name="content" >${dto.content}</textarea><br> 
			<input type="submit" value="수정하기">
	</form>

</body>
</html>