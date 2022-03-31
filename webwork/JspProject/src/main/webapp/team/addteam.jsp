<%@page import="team.TeamDao"%>
<%@page import="team.TeamDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<!-- jQuery library -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  request.setCharacterEncoding("utf-8");

  //입력값 읽기
  String name = request.getParameter("name");
  String driver = request.getParameter("driver");// 체크시 on, 미체크시 null
  String addr = request.getParameter("addr"); 

  // dto 선언
  TeamDto dto = new TeamDto();
  dto.setName(name);
  dto.setDriver(driver == null ? "없음" : "있음");
  dto.setAddr(addr);
  
  // dao 선언
  TeamDao dao = new TeamDao();
  
  dao.teamInsert(dto);
  
  response.sendRedirect("teamlist.jsp");
  %>
</body>
</html>