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
<%
request.setCharacterEncoding("utf-8");
String city = request.getParameter("city");
String[] cities = request.getParameterValues("city2");
%>
<body>
  <h2>희망 지역</h2>
  1순위: [<%=city%>]
  <br> 2순위:
  <%
  for (int i = 0; i < cities.length; i++) {
  %>
  [<%=cities[i]%>],
  <%
  }
  %>
</body>
</html>