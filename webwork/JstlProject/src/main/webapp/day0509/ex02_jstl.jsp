<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<c:set var="name" value="이광수"></c:set>
<c:set var="age" value="22"></c:set>
<c:set var="today" value="<%=new Date() %>"></c:set>

<!-- jstl 변수 출력하는 방법 -->
<h2>이름 : ${name }</h2>
<h2>나이: ${age }</h2>
<h2>오늘 날짜: ${today }</h2>

<!-- patter을 이용한 fmt 날짜 형식 -->
<pre>
  <fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/>
  <fmt:formatDate value="${today }" pattern="yyyy-MM-dd a hh:mm"/>
  <fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEE"/>
  <fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm EEEE"/>
</pre>

<!-- 숫자 -->
<c:set var="money" value="1234567000"></c:set>
<c:set var="num1" value="123.456789"></c:set>

<!-- jstl 숫자 출력 양식 -->
<pre>
  ${money} 
  ${num1 }
  
  <!-- 3자리마다 컴마 -->
  <fmt:formatNumber value="${money }" type="number"/>
  <fmt:formatNumber value="${money }" type="currency"/>
  
  <!-- pattern -->
  <fmt:formatNumber value="${1.2 }" pattern="0.00"/> <!-- 값이 없어도 무조건 0 출력 -->
  <fmt:formatNumber value="${1.2 }" pattern="0.##"/> <!-- 값이 없으면 출력 안함 -->
</pre>
</body>
</html>