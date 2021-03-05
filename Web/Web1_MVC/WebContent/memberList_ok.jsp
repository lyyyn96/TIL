<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.List, web.util.Member" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='main' method='post'>
		<input type='hidden' name='key' value='memberDelete'>
		<input name='id'>
		<input type='submit' value='회원 삭제'>
	</form>
	<br>
	<table border='1' width='300'>
		<tr><th>id</th><th>pw</th><th>name</th></tr>
		<%
			List<Member> list = (List<Member>)request.getAttribute("list");
			for(Member m:list){
				out.append("<tr><td>"+m.getId()+"</td><td>"+m.getPw()+"</td><td>"+m.getName()+"</td></tr>");
			}
		%>
	</table>
	<br><a href='index.html'>홈으로 가기</a>
</body>
</html>