<%@page import="data.dao.SmartDao"%>
<%@page import="data.dto.SmartDto"%>
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

request.setCharacterEncoding("utf-8");


SmartDto dto=new SmartDto();

dto.setWriter(request.getParameter("writer"));
dto.setSubject(request.getParameter("subject"));
dto.setContent(request.getParameter("content"));

SmartDao dao=new SmartDao();
dao.insertSmart(dto);

//목록
response.sendRedirect("../index.jsp?main=board/boardlist.jsp");
%>
</body>
</html>