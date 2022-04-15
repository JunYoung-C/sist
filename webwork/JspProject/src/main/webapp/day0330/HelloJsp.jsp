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
<h2>JSP는 HTML5구조에 자바코드를 사용할수있는 서버언어이다</h2>
<h2>Servlet은 확장자가 java이면 자바클래스 구조에 <br>
html,css,javascript도 사용할수 있다</h2>
<hr>
<h4>jsp는 주석이 2가지 가능</h4>
<hr>

<!-- 주석1: html기본주석:소스보기에선 보인다 -->
<%--jsp주석:소스보기에서도 안보인다  --%>
<%!
   //선언문
   //변수선언,메서드작성..클래스 멤버변수 등록
   //위치상관
%>

<h4>java코들를 쓰려면 scriptlet 영역을 표시후 코딩</h4>

<%
  //스크립트릿
  //여기서 선언하면 지역변수등록
  //선언한 곳보다 아래에서 사용해야 한다
  
  int age=20;
 String name="조아라";
 
 //내장객체인 out을 이용해서 브라우져에 출력
 out.print("내 이름은"+name+"이고 나이는"+age+"입니다");
%>

<h4>문자열이나 변수출력은 표현식을 이용해서 출력을 많이한다</h4>
<b>이름: </b><%=name %><br>
<b>나이: </b><%=age %>세<br>



</body>
</html>