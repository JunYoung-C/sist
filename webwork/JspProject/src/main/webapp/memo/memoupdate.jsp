<%@page import="memo.MemoDao"%>
<%@page import="memo.MemoDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
      href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
      rel="stylesheet"
    />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
request.setCharacterEncoding("utf-8");

String num = request.getParameter("unum");
String writer = request.getParameter("uwriter");
String content = request.getParameter("ucontent");
String avatar = request.getParameter("uavatar");

MemoDto dto = new MemoDto();
dto.setNum(num);
dto.setWriter(writer);
dto.setContent(content);
dto.setAvatar(avatar);

MemoDao dao = new MemoDao();
dao.updateMemo(dto);
%>
</body>
</html>