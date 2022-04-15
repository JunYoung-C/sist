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
String name=request.getParameter("name");
String hp=request.getParameter("hp");

System.out.println("name: "+name);
System.out.println("hp: "+hp);
%>
</body>
</html>