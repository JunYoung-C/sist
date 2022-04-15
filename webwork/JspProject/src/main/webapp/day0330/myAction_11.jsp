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
//한글엔코딩
request.setCharacterEncoding("utf-8");

String name=request.getParameter("name");
String pass=request.getParameter("pass");
String lic=request.getParameter("license");
%>

<h3>결과값 출력</h3>
이름:<%=name %><br>
비밀번호:<%=pass %><br>
운전면허:<%=lic==null?"없음":"있음" %>
</body>
</html>