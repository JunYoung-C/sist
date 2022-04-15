<%@page import="memo.MemoDao"%>
<%@page import="memo.MemoDto"%>
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
//한글엔코딩
request.setCharacterEncoding("utf-8");

//num,writer,content,avatar
String num=request.getParameter("unum");
String writer=request.getParameter("uwriter");
String content=request.getParameter("ucontent");
String avatar=request.getParameter("uavatar");

//dto에 넣어주기
MemoDto dto=new MemoDto();
dto.setNum(num);
dto.setWriter(writer);
dto.setContent(content);
dto.setAvatar(avatar);

//dao선언
MemoDao dao=new MemoDao();
//수정메서드 호출
dao.updateMemo(dto);
%>
</body>
</html>