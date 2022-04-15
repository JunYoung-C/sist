<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
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

MemberDto dto=new MemberDto();

String num=request.getParameter("num");
String name=request.getParameter("name");
String hp=request.getParameter("hp");
String addr=request.getParameter("addr");
String email=request.getParameter("email1")+"@"+request.getParameter("email2");

dto.setNum(num);
dto.setName(name);
dto.setHp(hp);
dto.setAddr(addr);
dto.setEmail(email);

MemberDao dao=new MemberDao();
dao.updateMember(dto);

//목록으로 이동
response.sendRedirect("../index.jsp?main=member/memberlist.jsp");
%>
</body>
</html>