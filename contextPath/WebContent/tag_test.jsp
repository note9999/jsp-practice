<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
	String str = "hi";
	int a =10;
	int b =20;
	
	public int add(int x, int y) {
		return x+y;
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>여기에는 선언문 작성함</h3>

<h3>선언문 끝</h3>
<h3>스크립트릿 시작</h3>
 
<%
	out.print("<h5>" + str + "</h5>");
	out.print("두수의 합 :" + add(a, b));
	
%>
	
	<h3>스트립트릿 끝</h3>
	<h3>표현식 작성시작</h3>
	
	<h5><%=str%></h5>
	<span>두수의 합: <%=add(a,b)%></span>
	<p>두개 뺸거: <%=a-b%></p>

	<h3>표현식 작성 끝</h3>
</body>
</html>