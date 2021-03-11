<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- foreach를 위한 taglib(library도 설치하여 붙여넣어야 함) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
    <tr>
		<th><b>번호</b></th>
		<th><b>아이디</b></th>
		<th><b>비밀번호</b></th>
		<th><b>이름</b></th>
		<th><b>가입일</b></th>
	</tr>
   
 <c:forEach var="m" items="${memberList}" varStatus="i" >     
	<tr>
		<td>${i.count}</td>
		<td>${m.id}</td>
		<td>${m.pw}</td>
		<td>${m.name}</td>
		<td>${m.date}</td>
		<td><a href="removeMember.do?id=${m.id}">삭제하기</a></td>
	</tr>
 </c:forEach>
  
  <%-- <%
  	List<MemberVO> list = request.getAttribute("memberList");
  	for(MemberVO m:list){
  		out.write("<tr><td>"+m.getId()+"</td><td>"+m.getPw()+"</td><td>"+
  				   m.getName+"</td><td>"+m.getDate+"</td></tr>");
  	}
  %> --%>
  
</table>
</body>
</html>