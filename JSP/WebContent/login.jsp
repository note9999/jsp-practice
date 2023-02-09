<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form method="post" action="login.do">
			<table>
				<tr>
					<td colspan="2">로그인</td>
				</tr>
				<tr>
					<td>아이디</td>					
					<td>
						<input type="text" name="id">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>					
					<td>
						<input type="password" name="pw">
					</td>
				</tr>
				<tr>
					<td>권한</td>					
					<td>
						<select name="lv">
							<option value="A">관리자</option>
							<option value="B">일반사원</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="로그인">
					</td>
				</tr>
				
			</table>
			<div style="text-align:center">
				<span >${msg}</span>
			</div>
		</form>
	
	
</body>
</html>