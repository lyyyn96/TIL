<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <div class="navbar-brand" id="loginDiv" href="#">
      <c:if test="${sessionScope.name !=null}">
      		${sessionScope.name }님 환영합니다.
      	</c:if>
      	<!-- <form action="main" method="post">
      	<input type="hidden" name="sign" value="login" id="msgDiv">
      		ID<input size="3" name="id">
      		PW<input size="3" name="pw" type="password">
      		<input type="submit" id="loginBtn" value="login">
      	</form> -->
      </div>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <c:choose>
            <c:when test="${sessionScope.name==null }">
            <a class="nav-link" href="#" onclick="window.open('login.html', '_blank', 'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=400');">로그인</a>
          </c:when>
          <c:otherwise>
          로그아웃
          </c:otherwise>
          </c:choose>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('basketView.jsp', '_blank','toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=400');">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('memberInsert.html', '_blank', 'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=450');">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('memberDelete.html', '_blank', 'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=300');">회원탈퇴</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>


</body>
</html>