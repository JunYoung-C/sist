<%@page import="memo.MemoDto"%>
<%@page import="memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//dao선언
MemoDao dao=new MemoDao();

//엔코딩
request.setCharacterEncoding("utf-8");

//데이타 읽기
String writer=request.getParameter("writer");
String content=request.getParameter("content");
String avatar=request.getParameter("avatar");

//dto로 묶어주기
MemoDto dto=new MemoDto();

dto.setWriter(writer);
dto.setContent(content);
dto.setAvatar(avatar);


//insert호출
dao.insertMemo(dto);
%>
</body>
</html>