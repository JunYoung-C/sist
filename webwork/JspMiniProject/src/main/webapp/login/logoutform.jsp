<%@page import="data.dao.MemberDao"%>
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
<div style="margin-left: 100px; margin-top: 50px;">
  <img alt="" src="image2/s6.JPG" width="200" align="left">

<%
//세션으로부터 아이디얻는다
String myid=(String)session.getAttribute("myid");

//db에 아이디에 해당하는 이름을 얻는다
MemberDao dao=new MemberDao();
String name=dao.getName(myid);
%>

<br><br>
<b><%=name %>님 로그인중..</b><br><br>
<button type="button" class="btn btn-danger"
onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
</div>
</body>
</html>