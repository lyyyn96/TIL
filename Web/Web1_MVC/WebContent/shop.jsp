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
	String name="";
	//Jsp가 자동으로 넣어줌
	//HttpSession session= request.getSession();
	name = (String)session.getAttribute("login_name");
	
	if(name==null){
		name="guest";
	}
	
	/*
	Cookie []all = request.getCookies();
	if(all!=null){
		for (Cookie c : all) {
			if (c.getName().equals("login_name")) {
			name = c.getValue();
			}
		}
	}
	*/
%>
	<%= name %>님 즐거운 쇼핑되세요. <a href='basketView.jsp'><%= name %>님의 장바구니 보기</a>
	<hr>
	
	<form action='main'>
	<input type='hidden' name='key' value='basketInsert'>
	<table>
		<tr><td><img src='img/냉장고.jpg' width=100%></td>
			<td><img src='img/TV.jpg' width=100%></td>
			<td><img src='img/세탁기.jpg' width=100%></td>
		</tr>
		<tr><td><input type='radio' name='product' value='냉장고'></td>
			<td><input type='radio' name='product' value='TV'></td>
			<td><input type='radio' name='product' value='세탁기'></td>
		</tr>
	</table>
	<br>
	<input type='submit' value='장바구니 넣기'>
	</form>
</body>
</html>