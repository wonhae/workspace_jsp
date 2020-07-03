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

	<h1>게시글 목록</h1>
	<a href="insertui.do">글쓰기</a> <hr>
	
	
	<!-- 실제로는 ul과  list item 으로~  -->
	<table border="1">
		<thead>
			<tr>
				<th>num</th>
				<th>title</th>
				<th>writer</th>
				<th>writeday</th>
				<th>redcnt</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr>
				<td>${dto.num}</td>
				<td width="200px">
				<c:forEach begin="1" end="${dto.repIndent}">  <!-- 포함..포함 -->
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
				<a href="read.do?num=${dto.num}">${dto.title}</a>
				</td>
				
				
				<td>${dto.writer}</td>
				<td>${dto.writeday}</td>
				<td>${dto.readcnt}</td>
				
				</tr>
			</c:forEach>
		</tbody>

	</table>

<!--화살표 클릭/// 프로젝트할 때 1페이지에 갔을대 왼쪽페이지 없어지게!! 3항연산자 싫으면 c if 쓸 것! 더 좋은 방법은 1페이지에서는 왼쪽으로 가는게 안보이게!! -->
	
	
	
	<a href="list.do?curPage=${(to.curPage-1) > 0 ? (to.curPage-1) : 1 }">&laquo;</a> &nbsp;&nbsp; 
	
	
	
	<c:forEach begin="${to.beginPageNum}" end="${to.stopPageNum}" var="idx">
	
		<c:if test="${to.curPage == idx}">    <!-- 현재페이지 글자 크게 -->
			<a style="font-size: 30px;" href="list.do?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
		
		<c:if test="${to.curPage != idx }">
			<a href="list.do?curPage=${idx}">${idx}</a>&nbsp;&nbsp;
		</c:if>
		
	</c:forEach>
	
	
	&nbsp;&nbsp;  <a href="list.do?curPage=${(to.curPage+1)< to.totalPage ? (to.curPage+1): to.totalPage }">&raquo;</a>

</body>
</html>