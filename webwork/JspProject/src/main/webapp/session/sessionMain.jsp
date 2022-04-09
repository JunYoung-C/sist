<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<% 
session.setAttribute("msg", "HappyTime");

session.setMaxInactiveInterval(5);

%>

<h2>10초 안에 눌러주세요</h2>
<form action="sessionAction.jsp" method="post">
  <h2>가고싶은 여행지는?</h2>
  <input type="radio" value="태국3박4일" name="travel">태국3박4일&nbsp;
  <input type="radio" value="캐나다3박4일" name="travel">캐나다3박4일&nbsp;
  <input type="radio" value="미국3박4일" name="travel">미국3박4일&nbsp;
  <input type="radio" value="스위스3박4일" name="travel">스위스3박4일&nbsp;
  <input type="submit" value="선택">
</form>
</body>
</html>