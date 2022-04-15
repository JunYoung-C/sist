<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>POST방식으로 읽기</h2>

<%
request.setCharacterEncoding("Utf-8");
String msg=request.getParameter("msg");
%>

<b>입력한 메세지는<br>
<font color="blue"><%=msg %></font>입니다</b>

</body>
</html>