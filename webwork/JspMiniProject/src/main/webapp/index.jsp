<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
div.layout{
border: 0px solid gray;
position: absolute;
}

div.title{
	width: 100%;
	height: 100px;
	text-align: center;
	vertical-align: bottom;
}

div.menu{
	width: 100%;
	height: 80px;
	line-height: 80px;
	font-size: 30pt;
	font-family: 'Hi Melody';
	text-align: center;
	top: 150px;
	
}

div.info{
	width: 170px;
	height: 200px;
	line-height: 10px;
	font-size: 15pt;
	font-family: 'Hi Melody';
	top: 350px;
	padding: 20px 10px;
	border: 5px groove gold;
	border-radius: 30px;
	left: 40px;
}

div.main{
	width: 1200px;
	height: 700px;
	font-size: 13pt;
	font-family: 'Hi Melody';
	left: 250px;
	top: 270px;
}

a,a:hover{
	text-decoration: none;
	color: black;
}
</style>
</head>
<%
//프로젝트 경로구하기
String root=request.getContextPath();

String mainPage="layout/main.jsp"; //기본페이지

//url을 통해서 main값을 읽어서 메인페이지에 출력한다
if(request.getParameter("main")!=null)
{
	mainPage=request.getParameter("main");
}

%>
<body>
<div class="layout title">
  <jsp:include page="layout/title.jsp"/>
</div>

<div class="layout menu">
  <jsp:include page="layout/menu.jsp"/>
</div>

<div class="layout info">
  <jsp:include page="layout/info.jsp"/>
</div>

<div class="layout main">
  <jsp:include page="<%=mainPage %>"/>
</div>
</body>
</html>