<%@page import="memo.MemoDto"%>
<%@page import="memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Gugi&family=Hi+Melody&family=Nanum+Myeongjo&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
//dao선언
MemoDao dao=new MemoDao();

//엔코딩
request.setCharacterEncoding("UTF-8");

//데이타 읽기
String writer=request.getParameter("writer");
String content=request.getParameter("content");
String avatar=request.getParameter("avatar");

//dto로 묶어주기
MemoDto dto = new MemoDto();

dto.setWriter(writer);
dto.setContent(content);
dto.setAvatar(avatar);

//insert호출
dao.insertMemo(dto);
%>
</body>
</html>