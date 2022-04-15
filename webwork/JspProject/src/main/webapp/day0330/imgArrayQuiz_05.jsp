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
<!-- 4행 5열로 img폴더에있는 이미지를 1~20까지 나타내보세요 
카톡 이미지 1장
-->
<table class="table table-bordered" style="width: 500px;">
<%
int n=0;
for(int row=1;row<=4;row++)
{%>
	<tr>
	  <%
	  for(int col=1;col<=5;col++)
	  {
	  n++;
	  %>
		  <td>
		    <img alt="" src="../img/<%=n%>.png" width="100" height="100">
		  </td>
	  <%}
	  %>
	</tr>
<%}
%>

</table>

</body>
</html>