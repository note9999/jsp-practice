<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

td{
	border: 1px solid black;
	width: 300px;
	text-align: center;
} 

span {
	color: red;
}
a{
	text-decoration: none;
}

table{
	margin:auto;
}

td:hover{
	background-color:lightgrey;
}

</style>

</head>
<body>

	<table>
		<tr>
				<td>${loginUser.name}</td> <!-- 로그인시 환영메시지 -->				
=======
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

td{
	border: 1px solid black;
	width: 300px;
	text-align: center;
} 

span {
	color: red;
}
a{
	text-decoration: none;
}

table{
	margin:auto;
}

td:hover{
	background-color:lightgrey;
}

</style>

</head>
<body>

	<table>
		<tr>
				<td></td> <!-- 로그인시 환영메시지 -->				
>>>>>>> refs/remotes/origin/master
				<td></td> <!-- 로그인시 등급 출력 -->				
				<td>
					<a href="login.jsp">로그인</a>
				</td>		
				<td>
					사원 등록<br>
					<span>관리자만 사용 가능</span>
				</td>
				<td>
					마이페이지<br>
					<span>로그인 후 사용가능</span>
				</td>
		</tr>
	</table>

</body>
</html>