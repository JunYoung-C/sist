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
<fmt:requestEncoding value="utf-8"/>
<form action="#" method="post">
  <table class="table table-bordered" style="width:300px;">
    <tr>
      <th bgcolor="orange" width="100">이름</th>
      <td>
        <input type="text" name="irum" class="form-control" style="width: 120px;">
      </td>
    </tr>
    
    <tr>
      <th bgcolor="orange" width="100">나이</th>
      <td>
        <input type="text" name="nai" class="form-control" style="width: 120px;">
      </td>
    </tr>
    
    <tr>
      <th bgcolor="orange" width="100">급여</th>
      <td>
        <input type="text" name="pay" class="form-control" style="width: 120px;">
      </td>
    </tr>
    
    <tr>
      <th bgcolor="orange" width="100">가고 싶은 나라</th>
      <td>
        <input type="text" name="nara" class="form-control" style="width: 120px;">
      </td>
    </tr>
    
    <tr>
      <td bgcolor="orange" colspan="2" align="center">
        <button type="submit" class="btn btn-danger">결과 확인</button>
      </td>
    </tr>
  </table>
</form>

<hr>
<!-- 이름을 입력했을 경우에만 div 출력 -->
<c:if test="${!empty param.irum }">
<div class="alert alert-info" style="width: 400px; font-size: 1.2em;">
  이름 :${ param.irum} <br>

  나이 :${ param.nai}세(
    <c:if test="${param.nai > 19}">
      성인
    </c:if>
    <c:if test="${param.nai <= 19}">
      미성년자
    </c:if>
  ) <br>
</div>
</c:if>
</body>
</html>