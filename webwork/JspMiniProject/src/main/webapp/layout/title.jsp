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
<%
  String root=request.getContextPath();
%>
<body>
<a href="<%=root%>/">
   <img alt="" src="<%=root%>/image/title.png" width="300px;">
</a>

<div style="float: right; padding-right: 100px;">
<%
String loginok=(String)session.getAttribute("loginok");
String myid=(String)session.getAttribute("myid");
MemberDao dao=new MemberDao();
String name=dao.getName(myid);

if(loginok==null){%>
	
	<button type="button" class="btn btn-success" 
	onclick="location.href='index.jsp?main=login/loginform.jsp'">Login</button>
<%}else{%>
	
	<b style="font-size: 12pt;"><%=name %>님 로그인중....</b>
	<button type="button" class="btn btn-success" 
	onclick="location.href='login/logoutaction.jsp'">Logout</button>
<%}
%>

</div>

</body>
</html>