<%@page import="member.MemberDto"%>
<%@page import="member.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hi+Melody&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<%
String num=request.getParameter("num");
MemberDao dao=new MemberDao();
MemberDto dto=dao.getData(num);

%>
<body>
<form action="updateformproc.jsp" method="post">
  <table class="table table-bordered" style="width: 350px;">
    <tr>
      <th>이름</th>
      <td>
        <input type="text" name="name" size="7"
        value="<%=dto.getName()%>">
      </td>
    </tr>
    
    <tr>
      <th>연락처</th>
      <td>
        <input type="text" name="hp" size="20"
        value="<%=dto.getHp()%>">
      </td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
      
      <!--hidden으로  num을 넘겨준다..위치든 폼안에만 있음됨 -->
      	<input type="hidden" name="num" value="<%=dto.getNum()%>">
        <input type="submit" value="수정" class="btn btn-info">
        <input type="button" value="목록" 
        onclick="location.href='memberlist.jsp'"
        class="btn btn-danger">
      </td>
    </tr>
  </table>
</form>
</body>
</html>