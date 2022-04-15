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
session.setAttribute("msg", "HappyTime");
session.setMaxInactiveInterval(10);

%>

<h2>10초안에 눌러주세요!!!</h2>
<form action="sessionAction.jsp" method="post">
  <h2>가고싶은 여행지는?</h2>
    <input type="radio" value="태국3박4일" name="travel">태국3박4일&nbsp;
    <input type="radio" value="동유럽10박" name="travel">동유럽10박&nbsp;
    <input type="radio" value="캐나다 로키 8박" name="travel">캐나다 로키 8박&nbsp;
    <input type="radio" value="그리스 산토리니11박" name="travel">그리스 산토리니11박&nbsp;
    <input type="submit" value="상품신청">
</form>
</body>
</html>