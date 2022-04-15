<%@page import="sinsang.SinsangDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hi+Melody&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- 비밀번호가 무조건 a1234면 삭제 -->
<%
String pass=request.getParameter("pass");
String num=request.getParameter("num");
SinsangDao dao=new SinsangDao();


//비밀번호 확인후 맞으면 ssdelete.jsp로 이동
//틀리면 이전화면으로 이동
if(pass.equals("a1234")){
		
	//목록으로 이동
	dao.deleteSinsang(num);
	response.sendRedirect("sslist.jsp");
	
}else
{%>
	<script type="text/javascript">
	alert("비밀번호가 맞지않습니다");
	history.back();
	</script>
<%}
	
%>
</body>
</html>