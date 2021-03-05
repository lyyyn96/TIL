<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<%@ include file="header.html" %>
<body>
	${name }님 환영합니다.<br>
	<a href='shop.jsp'>쇼핑 가기</a><br>
	
<%

%>
	
	
	
	<%--
	<jsp:include page="img.html"></jsp:include><br>
	
	<!-- i는 멤버변수 j는 지역변수 -->
	<%= i++ %><br>
	<% printI(); %>
	<% int j=0; %>
	<%= j++ %>
	<%!
	int i=10;
  	public void printI(){
  		System.out.println(i);
  	}
	%>
	--%>
</body>
</html>
