<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% 
List<String> list = new ArrayList<>();
list.add("장미");
list.add("국화");
list.add("작약");
list.add("후리지아");
list.add("다일리아");

request.setAttribute("list", list);
session.setAttribute("id", "angel");
session.setAttribute("hp", "010-1234-4567");
%>
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
<h1>request list 출력</h1>
<c:forEach var="s" items="${requestScope.list }" varStatus="i">
  ${i.count }: ${s }<br>
</c:forEach>
</body>
</html>