<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
작성자: ${dto.writer }<br>
작성일:  <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/><br>
제목: ${dto.subject }<br>
내용:
<pre>
  ${dto.content }
</pre>
<br><br>
<button type="button" class="btn btn-success btn sm"
onclick="location.href='writeform'">글쓰기</button>

<button type="button" class="btn btn-success btn sm"
onclick="location.href='list'">목록</button>

<button type="button" class="btn btn-success btn sm"
onclick="location.href='updateform?num=${dto.num}'">수정</button>

<button type="button" class="btn btn-success btn sm"
onclick="location.href='delete?num=${dto.num}'">삭제</button>
</body>
</html>