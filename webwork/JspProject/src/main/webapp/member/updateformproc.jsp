<%@page import="member.MemberDao"%>
<%@page import="member.MemberDto"%>
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

String num=request.getParameter("num");
String name=request.getParameter("name");
String hp=request.getParameter("hp");

MemberDto dto=new MemberDto();

dto.setNum(num);
dto.setName(name);
dto.setHp(hp);

//update호출
MemberDao dao=new MemberDao();
dao.memberUpdate(dto);

//목록
response.sendRedirect("memberlist.jsp");
%>
</body>
</html>