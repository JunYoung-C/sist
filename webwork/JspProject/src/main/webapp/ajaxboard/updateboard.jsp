<%@page import="ajaxboard.AjaxBoardDao"%>
<%@page import="ajaxboard.AjaxBoardDto"%>
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
//post방식으로보냄
request.setCharacterEncoding("utf-8");
String num=request.getParameter("unum");
String writer=request.getParameter("uwriter");
String subject=request.getParameter("usubject");
String content=request.getParameter("ucontent");
String avata=request.getParameter("uavata");

//dto선언
AjaxBoardDto dto=new AjaxBoardDto();
dto.setNum(num);
dto.setWriter(writer);
dto.setSubject(subject);
dto.setContent(content);
dto.setAvata(avata);

//update
AjaxBoardDao db=new AjaxBoardDao();
db.updateBoard(dto);
%>
</body>
</html>