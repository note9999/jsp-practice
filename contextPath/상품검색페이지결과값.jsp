<%@page import="com.sun.corba.se.spi.orb.StringPair"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String age =request.getParameter("age");
	String category =request.getParameter("category");
	String[] colors =request.getParameterValues("color");
	
%>
	<h1><%=age %>
	세가 가장 많이 구매한<%=category %>들을 조회합니다.</h1>
	<h2>선호하는 색상
<%
	if(colors==null) {
		
%>
		이 없습니다.</h2>
<% 
	
	}else {
	for(String color : colors) {
%>	
		<%=color%>
<% 
		} 
%>	

	입니다.
<%
	}
%>
	</h2>

</body>

</html>