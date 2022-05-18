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
<div class="alert alert-info">
  <b>총 ${totalCount }개의 데이타가 있습니다</b>
</div>
<br>
<button type="button" class="btn btn-info"
onclick="location.href='form'">글쓰기</button>
<br>
<hr>
<table class="table table-bordered" style="width: 800px;">
  <tr bgcolor="#ffc">
    <th width="50">번호</th>
    <th width="80">이름</th>
    <th width="100">사진</th>
    <th width="80">운전면허</th>
    <th width="180">주소</th>
    <th width="180">가입일</th>
    <th width="100">편집</th>
  </tr>
  <c:forEach var="dto"  items="${list }" varStatus="i">
    <tr>
      <td align="center">${i.count }</td>
      <td>${dto.name }</td>
      <td>
         <c:if test="${dto.photo!='no' }">
           <img alt="" src="../photo/${dto.photo }" width="60" height="60" class="img-circle">
         </c:if>
         <c:if test="${dto.photo=='no' }">
         	<img alt="" src="../photo/1.png" width="60" height="60" class="img-circle">
         </c:if>
      </td>
      <td>${dto.driver }</td>
        <td>${dto.addr }</td>
        <td>
          <fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
        </td>
        <td>
          <button type="button" class="btn btn-info btn-xs">수정</button>
          <button type="button" class="btn btn-danger btn-xs">삭제</button>
        </td>
     
    </tr>
  </c:forEach>
</table>

</body>
</html>