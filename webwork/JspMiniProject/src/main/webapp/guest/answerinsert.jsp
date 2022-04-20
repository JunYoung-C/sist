<%@page import="data.dao.AnswerDao"%>
<%@page import="data.dto.AnswerDto"%>
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
AnswerDto dto=new AnswerDto();
dto.setNum(request.getParameter("num"));
dto.setMyid(request.getParameter("myid"));
dto.setContent(request.getParameter("content"));

String currentPage=request.getParameter("currentPage");

AnswerDao dao=new AnswerDao();
dao.insertAnswer(dto);

//목록 보던페이지로 이동
response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);
%>
</body>
</html>