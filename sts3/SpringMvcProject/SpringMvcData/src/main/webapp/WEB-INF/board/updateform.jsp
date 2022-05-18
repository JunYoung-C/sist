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
<form action="update" method="post">

<!-- hidden으로 num넘기기 -->
<input type="hidden" name="num" value="${dto.num}">

  <table class="table table-bordered" style="width: 400px;">
    <caption><b>글수정</b></caption>
      <tr>
        <th width="100">작성자</th>
          <td>
            <input type="text" name="writer" class="form-control input-sm" style="width: 100px;"
            value="${dto.writer}">
          </td>
      </tr>
      <tr>
        <th width="100">제목</th>
          <td>
            <input type="text" name="subject" class="form-control input-sm" style="width: 300px;"
            value="${dto.subject }">
          </td>
      </tr>
      <tr>
        <td colspan="2">
          <textarea style="width: 400px; height: 200px; " name="content"
          class="form-control">${dto.content }</textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
          <button type="submit" class="btn btn-danger">db수정</button>
        </td>
      </tr>
  </table>
</form>
</body>
</html>