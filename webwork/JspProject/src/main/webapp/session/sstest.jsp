<%@page import="java.util.Date"%>
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
session.setAttribute("msg", "Happy day");

session.setMaxInactiveInterval(60);

%>

<h3>세션 값 얻기</h3>
세션값: <%= session.getAttribute("msg") %><br>
세션 유지 기간: <%= session.getMaxInactiveInterval() %>초<br>
세션 생성 기간: <%= session.getCreationTime() %>초<br>
세션 생성 기간: <%= new Date(session.getCreationTime()) %>초<br>
</body>
</html>