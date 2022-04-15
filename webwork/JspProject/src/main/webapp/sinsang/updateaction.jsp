<%@page import="sinsang.SinsangDao"%>
<%@page import="sinsang.SinsangDto"%>
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
	request.setCharacterEncoding("UTF-8");
	
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String blood=request.getParameter("blood");
	String birth=request.getParameter("birth");
	String hp=request.getParameter("hp1")+"-"
			+request.getParameter("hp2")+"-"
			+request.getParameter("hp3");
	
	SinsangDto dto=new SinsangDto();

	dto.setNum(num);
	dto.setName(name);
	dto.setBlood(blood);
	dto.setHp(hp);
	dto.setBirth(birth);

	SinsangDao db=new SinsangDao();
	db.updateSinsang(dto);
	
	response.sendRedirect("sslist.jsp");
%>

</body>
</html>