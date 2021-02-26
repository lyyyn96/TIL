<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	아이디=${id } 패스워드=${pw }
	<br><a href='index.html'>이전으로 가기</a>
	<br><img src='java_duke.png'>
	<%
	//jsp 처리 block. java 코드가 실행 가능
	//하지만 html에 java 코드가 들어가면 지저분하므로
	//java 코드가 없는 방향으로 흘러감
	/* //String id = (String)request.getAttribute("id");
	//String pw = (String)request.getAttribute("pw");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	out.append("id="+id+" pw="+pw);
	out.append("<br><a href='index.html'>이전으로 가기</a>");
	out.append("<br><img src='java_duke.png'>"); */
	%>
</body>
</html>