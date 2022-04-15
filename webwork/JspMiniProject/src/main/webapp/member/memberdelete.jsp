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

//dao
MemberDao dao=new MemberDao();

//비번체크후 맞으면 삭제,아니면 경고후 이전으로
boolean b=dao.isPassEqual(num, pass);

if(b){
	dao.deleteMember(num);
	
	//삭제후 리스트로 이동
	response.sendRedirect("../index.jsp?main=member/memberlist.jsp");
}else{%>
	 <script type="text/javascript">
	 alert("비밀번호가 맞지않아요!!");
	 history.back();
	 </script>
<%}

%>
</body>
</html>