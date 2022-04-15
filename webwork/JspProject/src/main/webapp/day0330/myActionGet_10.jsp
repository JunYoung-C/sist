<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Get방식으로 읽기</h2>
<%
String msg=request.getParameter("msg");
%>

<b>입력한 메세지는 <br>
<font color="magenta"><%=msg %></font></b>
</body>
</html>