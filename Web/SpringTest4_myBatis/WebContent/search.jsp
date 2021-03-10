<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<table border="1">
		   <tr>
		      <td><b>아이디</b></td>
		      <td><b>비밀번호</b></td>
		      <td><b>이름</b></td>
		      <td><b>가입일</b></td>
		   </tr>
		   <tr>
		      <td>${member.id} </td>
		      <td>${member.pw} </td>
		      <td>${member.name} </td>
		      <td>${member.date}</td>
		    </tr>
		</table>
	</form>
</form>
</body>
</html>