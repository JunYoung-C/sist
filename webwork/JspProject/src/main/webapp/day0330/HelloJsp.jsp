<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<!-- jQuery library -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>JSP는 HTML5 구조에 자바코드를 사용할 수 있는 서버 언어이다.</h2>
  <!-- 주석1: html 기본 주석 : 소스보기에선 보인다. -->
  <%-- JSP주석: 소스보기에서도 안보인다. --%>

  <%!//선언문
  // 변수 선언, 메서드 작성, 클래스 멤버 변수 등록
  // 위치 상관%>

  <%
  int age = 20;
  String name = "조아라";
  %>
  
  <h4>문자열이나 변수 출력은 표현식을 이용해서 출력을 많이한다.</h4>
  <b>이름: <b><%=name %></b></b>
  <b>나이: <b><%=age %></b></b>
</body>
</html>