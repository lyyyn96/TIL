<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frmLogin" method="post" action="login.do">
		<table border="1" width="80%" align="center">
		<tr align="center">
			<td>아이디</td>
			<td>비밀번호</td>
		</tr>
		<tr align="center">
			<td><input type="text" name="userID" value="" size="20"></td>
			<td><input type="password" name="passwd" value="" size="20"></td>
		</tr>
		</table>
		<input type="submit" value="로그인">
	</form>
</body>
</html>