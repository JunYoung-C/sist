<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<%
  String root=request.getContextPath();
%>
<body>
<a href="<%=root%>/">Home</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=root%>/">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="index.jsp?main=member/memberform.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=root%>/">방명록</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=root%>/">Q&A</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=root%>/">답변형게시판</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="<%=root%>/">상품등록게시판</a>&nbsp;&nbsp;&nbsp;&nbsp;
</body>
</html> --%>

<!DOCTYPE html>
<html class="csstransforms no-csstransforms3d csstransitions"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	
	<link rel="stylesheet" type="text/css" href="menu/css/font-awesome.css">
	<link rel="stylesheet" type="text/css" href="menu/css/menu.css">
    
	<script type="text/javascript" src="menu/js/jquery.js"></script>
	<script type="text/javascript" src="menu/js/function.js"></script>

</head>
<body>

<div id="wrap">
	<header>
		<div class="inner relative">
			<a class="logo" href="http://www.freshdesignweb.com"></a>
			<a id="menu-toggle" class="button dark" href="#"><i class="icon-reorder"></i></a>
			<nav id="navigation">
				<ul id="main-menu">
					<li class="current-menu-item"><a href="index.jsp">Home</a></li>
					<li class="parent">
						<a href="#">Member</a>
						<ul class="sub-menu">
							<li><a href="index.jsp?main=member/memberform.jsp"><i class="icon-wrench"></i> 회원가입폼</a></li>
							<li><a href="index.jsp?main=member/memberlist.jsp"><i class="icon-credit-card"></i>  회원목록</a></li>
							<li><a href="#"><i class="icon-gift"></i> Icons</a></li>
							<li>
								<a class="parent" href="#"><i class="icon-file-alt"></i> Pages</a>
								<ul class="sub-menu">
									<li><a href="#">Full Width</a></li>
									<li><a href="#">Left Sidebar</a></li>
									<li><a href="#">Right Sidebar</a></li>
									<li><a href="#">Double Sidebar</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li><a href="index.jsp?main=login/loginmain.jsp">로그인</a></li>
					<li class="parent">
						<a href="#">Board</a>
						<ul class="sub-menu">
							<li><a href="index.jsp?main=guest/guestlist.jsp">회원방명록</a></li>
							<li><a href="#">Medium Image</a></li>
							<li><a href="#">Masonry</a></li>
							<li><a href="#">Double Sidebar</a></li>
							<li><a href="#">Single Post</a></li>
						</ul>
					</li>
					<li><a href="#">Contact</a></li>
				</ul>
			</nav>
			<div class="clear"></div>
		</div>
	</header>	
</div>    
</body></html>