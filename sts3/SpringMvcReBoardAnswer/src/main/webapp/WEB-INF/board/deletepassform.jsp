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
<div style="margin: 100px 100px;">
  <form action="delete" method="post" class="form-inline">
    <!--hidden  -->
    <input type="hidden" name="num" value="${num }">
    <input type="hidden" name="currentPage" value="${currentPage}">
    <div class="alert alert-info" style="font-size: 1.4em; width: 350px;">
      <b>비밀번호를 입력해 주세요</b>
    </div>
    <div>
      <input type="password" name="pass" class="form-control"
      style="width: 120px;" required="required">&nbsp;&nbsp;
        <button type="submit" class="btn btn-info">삭제하기</button>
        <button type="button" class="btn btn-info"
        onclick="history.back()">이전으로</button>
    </div>
  </form>

</div>
</body>
</html>