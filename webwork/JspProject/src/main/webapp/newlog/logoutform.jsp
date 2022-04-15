<%@page import="newmem.NewmemDao"%>
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
</head>
<body>
<%
String loginok=(String)session.getAttribute("loginok");

if(loginok==null)
{%>
	<button class="btn btn-info" style="width: 120px; margin-left: 100px;"
	onclick="location.href='loginform.jsp'">로그인</button>
<%}else
{
	NewmemDao dao=new NewmemDao();
	//세션에 저장된 아이디 얻기
	String id=(String)session.getAttribute("mid");
	//아이디에 해당하는 name얻기
	String name=dao.getName(id);
	%>
	
	<b><%=name %>님이 로그인하셨습니다</b>
	<button class="btn btn-success" style="width: 120px; margin-left: 30px;"
	onclick="location.href='logoutaction.jsp'">로그아웃</button>
<%}
%>
<hr>
<img alt="" src="../image/mainImg.png">

</body>
</html>