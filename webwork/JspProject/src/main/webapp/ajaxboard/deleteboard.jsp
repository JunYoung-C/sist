<%@page import="ajaxboard.AjaxBoardDao"%>
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
String num=request.getParameter("num");
AjaxBoardDao db=new AjaxBoardDao();
db.deleteBoard(num);
%>
</body>
</html>