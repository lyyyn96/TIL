<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	${name }님 환영합니다.<br>
	<form main="action" method="post">
	<input type="hidden" name="sign" value="page">
	<input type="submit" value="닫기" id="pageBtn">
	</form>
</body>
</html>
 --%>
 
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>DOGGY</title>

  <!-- Bootstrap core CSS -->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="css/shop-homepage.css" rel="stylesheet">
	
	<script type="text/javascript" src="logout.js"></script>

	<style>
	/* .a{
		display:flex;
		width: 30%;
		padding:28px;
		float: left;
	}
	.b{
		display:flex;
		width: 30%;
		padding:28px;
		float: left;
	}
	
	.c{
		display:flex;
		width: 30%;
		padding:28px;
		float : right;
	}
	
	.d{
		display:flex;
		width: 30%;
		padding:28px;
		float: left;
	}
	.e{
		display:flex;
		width: 30%;
		padding:28px;
		float: left;
	}
	
	.f{
		display:flex;
		width: 30%;
		padding:28px;
		float : right;
	} */
	
	.a{
	margin-top: 30px;
	float: left;
    width:30%;
    box-sizing: border-box;
	}
	
	.b{
	margin-top: 30px;
	float: left;
    margin-left: 5%;
    width:30%;
    box-sizing: border-box;
	}
	
	.c{
	margin-top: 30px;
    float: right;
    width:30%;
    box-sizing: border-box;
    }
    
    .d{
    margin-top: 30px;
	float: left;
    width:30%;
    box-sizing: border-box;
	}
	
	.e{
	margin-top: 30px;
	float: left;
    margin-left: 5%;
    width:30%;
    box-sizing: border-box;
	}
	
	.f{
	margin-top: 30px;
    float: right;
    width:30%;
    box-sizing: border-box;
    }
    
    footer{
    	margin-top:30px;
    }
	#resetBtn{
		position: absolute; right: 30px;
		top: 586px;
	}
	
	#basketInsertBtn{
		position: absolute; right: 100px;
		top: 586px;
	}

	.bg-dark {
	background-color: #6495ED !important;
    /*background-color: 	#2E8B57 !important;*/
	}
	
	.my-4{
	color: #191970;
	/*color: 	#006400;*/
	}
	
	</style>
	
	<!-- 웹 페이지 크기 및 위치 자동 고정하기 -->
	<script>
	window.onfocus=function(){
	}
	window.onload=function(){
	 window.focus(); // 현재 window 즉 익스플러러를 윈도우 최상단에 위치
	window.moveTo(0,0); // 웹 페이지의 창 위치를 0,0 (왼쪽 최상단) 으로 고정
	window.resizeTo(1536,824); // 웹페이지의 크기를 가로 1280 , 세로 800 으로 고정(확장 및 축소)
	window.scrollTo(0,0); // 페이지 상단 광고를 바로 볼 수 있게 스크롤 위치를 조정
	}
	</script>
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
	
	%>
  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <div class="navbar-brand" id="loginDiv" href="#">
      <%= name %>님 환영합니다.
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
        	<form action="main" method="post">
            <input type="hidden" name="sign" value="logout">
            <input class="nav-link" href="index.html" type="submit" value="로그아웃" 
            style="background-color:transparent;  border:0px transparent solid;">
  
            </form>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('basketView.jsp', '_blank',
            		'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=400');">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('memberInsert.html', '_blank', 
            		'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=450');">회원가입</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#" onclick="window.open('memberDelete.html', '_blank', 
            		'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=300');">회원탈퇴</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">DOGGY</h1>
        <div class="list-group">
          <a href="#" class="list-group-item">사료</a>
          <!-- <a href="#" class="list-group-item">Category 2</a>
          <a href="#" class="list-group-item">Category 3</a> -->
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="img/banner1.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="img/banner2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="img/banner4.png" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">
		<form action="main" method="post">
		<input type="hidden" name="sign" value="basketInsert">
          <div class="a">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food1.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 제니스 어덜트 1.2KG</a>
                </h4>
                <h5>10000원</h5>
                <p class="card-text">본 제품은 신선한 양고기(생육)과 감자를 주 원료로 당사의 독자적인 노하우를 접목시킨 국내 유일의 생육 첨가 반건조 제품으로 조직이 부드러워 소화가 잘되고 기호성이 뛰어납니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="제니스 어덜트 1.2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>

          <div class="b">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food2.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 제니스 퍼피 &nbsp;&nbsp;&nbsp; 1.2KG</a>
                </h4>
                <h5>15000원</h5>
                <p class="card-text">본 제품은 신선한 국내산 닭가슴살과 감자를 주 원료로 당사의 독자적인 노하우를 접목시킨 국내 유일의 생육 첨가 반건조 제품으로 조직이 부드러워 소화가 잘되고 기호성이 뛰어납니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="제니스 퍼피 1.2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>

          <div class="c">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food3.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 제니스 시니어 1.2KG</a>
                </h4>
                <h5>10500원</h5>
                <p class="card-text">본 제품은 신선한 양고기(생육)과 감자를 주 원료로 당사의 독자적인 노하우를 접목시킨 국내 유일의 생육 첨가 반건조 제품으로 조직이 부드러워 소화가 잘되고 기호성이 뛰어납니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="제니스 시니어 1.2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>

          <div class="d">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food4.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 오리지-7 소고기 2KG</a>
                </h4>
                <h5>18500원</h5>
                <p class="card-text">Real meat (Beef & organic free-run chicken)
				미국 USDA 인증 Free-run chicken (유기농 방목 닭) 사용, meat meal은 사용하지 않습니다.
				Fresh meat 30%이상 소화흡수율 향상에 도움을 줍니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="오리지-7 소고기 2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>

          <div class="e">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food5.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 오리지-7 양고기 2KG</a>
                </h4>
                <h5>18500원</h5>
                <p class="card-text">Real meat (Lamb & organic free-run chicken)
				미국 USDA 인증 Free-run chicken (유기농 방목 닭) 사용, meat meal은 사용하지 않습니다.
				Fresh meat 30%이상 소화흡수율 향상에 도움을 줍니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="오리지-7 양고기 2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>

          <div class="f">
            <div class="card h-100">
              <a href="#"><img class="card-img-top" src="img/food6.jpg" alt=""></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#"> 오리지-7 연어 &nbsp;&nbsp;&nbsp; 2KG</a>
                </h4>
                <h5>18500원</h5>
                <p class="card-text">Real meat (Salmon & organic free-run chicken)
				미국 USDA 인증 Free-run chicken (유기농 방목 닭) 사용, meat meal은 사용하지 않습니다.
				Fresh meat 30%이상 소화흡수율 향상에 도움을 줍니다.</p>
              </div>
              <div class="card-footer">
                <input type="checkbox" name="product" value="오리지-7 연어 2KG"><!-- <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small> -->
              </div>
            </div>
          </div>
			<input type="submit" id="basketInsertBtn" href="#" onclick="window.open('basketInsert_ok.jsp', '_blank',
            		'toolbar=yes,scrollbars=yes,resizable=yes,top=50,left=500,width=400,height=400');" value="장바구니 넣기">
			<input id="resetBtn" type="reset" value="reset"><br>
		</form>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2020</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
 