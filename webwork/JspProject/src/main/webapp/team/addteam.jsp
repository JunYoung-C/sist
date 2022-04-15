<%@page import="team.TeamDao"%>
<%@page import="team.TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hi+Melody&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

//입력값 읽기
String name=request.getParameter("name");
String driver=request.getParameter("driver");
String addr=request.getParameter("addr");

//dto선언
TeamDto dto=new TeamDto();

dto.setName(name);
dto.setDriver(driver==null?"없음":"있음");
dto.setAddr(addr);

//dao선언
TeamDao dao=new TeamDao();
//insert호출
dao.teamInsert(dto);

//목록파일로 이동
response.sendRedirect("teamlist.jsp"); //해당파일로 이동
%>
</body>
</html>