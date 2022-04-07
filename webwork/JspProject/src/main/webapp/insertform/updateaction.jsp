<%@page import="sinsang.SinsangDao"%>
<%@page import="sinsang.SinsangDto"%>
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

String num = request.getParameter("num");
String name = request.getParameter("name");
String blood = request.getParameter("blood");
String birth = request.getParameter("birth");
String hp = request.getParameter("hp1") + "-" + request.getParameter("hp2") + "-"
    + request.getParameter("hp3");

SinsangDto dto = new SinsangDto();
dto.setNum(num);
dto.setName(name);
dto.setBlood(blood);
dto.setHp(hp);
dto.setBirth(birth);

SinsangDao dao = new SinsangDao();
dao.updateSinsang(dto);

response.sendRedirect("sslist.jsp");
%>
</body>
</html>