<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String num=request.getParameter("num");
String pass=request.getParameter("pass");

//비번맞는지 체크
MemberDao dao=new MemberDao();
boolean b=dao.isPassEqual(num, pass);

if(b){
	
	response.sendRedirect("../index.jsp?main=member/updateform.jsp?num="+num);
}else{%>
	
	<script type="text/javascript">
	alert("비밀번호가 틀렸어요");
	history.back();
	</script>
<%}
%>
</body>
</html>