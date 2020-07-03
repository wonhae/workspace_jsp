<%@page import="kr.co.dto.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="insertui">회원 등록</a>

	<h1>모든 회원 정보 목록</h1>
	
	
	<!-- db에서 넘겨준 데이터를 jsp에 뿌리는 작업을 한다 -->
	<!--  < %....jstl??하면 더 편한 방법있다. 지금은 그냥 따라하기 -->
	
	<!-- 틀만 가져온다. db 접근하려면 servlet -->
	<%
		Object oList = request.getAttribute("list");  
		List<MemberDTO> list = null;
		if(oList != null) {
			list = (List<MemberDTO>)oList; //자식자료형에 부모 생성자 ->강제형변화
			
			for(int i = 0; i < list.size(); i++) {
				MemberDTO dto = list.get(i);
				
				out.print(dto.toString());  //toString생략해도됨
				out.print("<br>");
				
			}
		}
	%>
	
</body>
</html>