<%@page import="sinsang.SinsangDto"%>
<%@page import="java.util.Vector"%>
<%@page import="sinsang.SinsangDao"%>
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
SinsangDao db=new SinsangDao();
Vector<SinsangDto> list=db.getAllDatas();
%>
<body>
<a href="insertform.jsp"><button type="button"
class="btn btn-success">데이터추가</button></a>

<hr>

<table class="table table-bordered" style="width: 700px;">
  <caption><b>신상정보</b></caption>
  <tr>
    <th width="50">No.</th>
    <th width="70">이름</th>
    <th width="180">연락처</th>
    <th width="80">혈액형</th>
    <th width="180">생년월일</th>
    <th width="150">편집</th>
  </tr>
  
  <%
  for(int i=0;i<list.size();i++)
  {
	  SinsangDto dto=list.get(i);
	  %>
	  <tr>
	    <td align="center"><%=i+1 %></td>
	    <td><%=dto.getName() %></td>
	    <td><%=dto.getHp() %></td>
	    <td align="center"><%=dto.getBlood() %>형</td>
	    <td align="center"><%=dto.getBirth() %></td>
	    <td align="center">
	      <button type="button" class="btn btn-info btn-xs"
	      onclick="location.href='updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
	      <button type="button" class="btn btn-danger btn-xs"
	      onclick="location.href='passform.jsp?num=<%=dto.getNum()%>'">삭제</button>
	    </td>
	  </tr>
	  
  <%}
  %>
</table>



</body>
</html>