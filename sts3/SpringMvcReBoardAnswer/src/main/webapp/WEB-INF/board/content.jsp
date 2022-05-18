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
<style type="text/css">
#answer{
	border-bottom: 1px solid #ddd;
	margin-bottom: 20px;
	padding-top: 10px;
	padding-bottom: 10px;
	padding-left: 20px;
}
</style>
<title>Insert title here</title>
</head>
<body>
<div style="margin: 50px 50px;">
  <table class="table table-bordered" style="width: 600px;">
    <caption><b>내용보기</b></caption>
      <tr>
        <td>
          <h3><b>${dto.subject }</b></h3>
            <span style="float: right; margin-right: 20px;">
            조회 ${dto.readcount }&nbsp;&nbsp;&nbsp;
            <fmt:formatDate value="${dto.writeday }" pattern="yyyy-MM-dd HH:mm"/>
            </span>
            <br>
            <h5><b> ${dto.writer }</b></h5>
        </td>
      </tr>
      
      <tr>
        <td>
          <pre>${dto.content }</pre>
          <br><br>
          <c:if test="${dto.photo!='no' }">
          <c:forTokens var="pi" items="${dto.photo }" delims=",">
          	<a href="../photo/${pi }">
          	<img alt="" src="../photo/${pi }" style="max-width: 150px;"></a>
          </c:forTokens>
          </c:if>
        </td>
      </tr>
      
      <!--댓글  -->
      
      <tr>
        <td>
            <div id="answer">
            <b>댓글: ${acount } </b><br><br>
            <c:forEach var="a" items="${alist }">
            ${a.nickname }: &nbsp;&nbsp;${a.content } &nbsp;&nbsp;
            <span style="color: gray; font-size: 0.8em;">
              <fmt:formatDate value="${a.writeday }" pattern="yyyy-MM-dd HH:mm"/>
            </span>
            &nbsp;&nbsp;
            <span class="glyphicon glyphicon-pencil" style="cursor: pointer;"></span>&nbsp;
            <span class="glyphicon glyphicon-trash" style="cursor: pointer;"></span><br>
            </c:forEach>
            
            
            </div>
            <form action="ainsert" method="post" class="form-inline">
              <input type="hidden" name="num" value="${dto.num }">
              <input type="hidden" name="currentPage" value="${currentPage}">
              <div>
                <b style="font-size: 0.8em;">닉네임: </b>
                <input type="text" name="nickname" class="form-control"
                style="width: 100px;" required="required">
                <b style="margin-left: 30px; font-size: 0.8em;">비밀번호: </b>
                <input type="text" name="pass" class="form-control"
                style="width: 100px;" required="required">
                <br><br>
                <input type="text" name="content" class="form-control"
                style="width: 500px;" required="required" placeholder="댓글 내용을 입력해주세요">
                <button type="submit" class="btn btn-default">확인</button>
              </div>
            </form>
        </td>
      </tr>
      
      <tr>
        <td align="right">
          <button class="btn btn-info btn-sm"
          onclick="location.href='writeform'">글쓰기</button>
          
          <button class="btn btn-info btn-sm"
          onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup}&restep=${dto.restep}&relevel=${dto.relevel}&currentPage=${currentPage}'">답글</button>
          
          <button class="btn btn-info btn-sm"
          onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage}'">수정</button>
          
          <button class="btn btn-info btn-sm"
          onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage}'">삭제</button>
          
          <button class="btn btn-info btn-sm"
          onclick="location.href='list?currentPage=${currentPage}'">목록</button>
        </td>
      </tr>
      
      
      
  </table>
</div>
</body>
</html>