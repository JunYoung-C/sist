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
<style type="text/css">
img.mainimg{
	width: 250px;
	height: 170px;
	border: 1px solid gray;
	margin-left: 50px;
	border-radius: 20px;
}

table.maintb{width: 700px;}

table.maintb tr {
	height: 200px;
}

img.mainimg:hover{
	cursor: pointer;
	width: 300px;
	height: 200px;
	border: 5px solid gray;
}
</style>
</head>
<body>
<table class="maintb">
<%
int n=0;

for(int row=1;row<=3;row++)
{%>
	<tr>
	<%
	for(int col=1;col<=4;col++)
	{
		n++;
		%>
		<td>
		  <img alt="" src="image/<%=n%>.png" class="mainimg">
		</td>
	<%}
	%>
	</tr>
<%}
%>
</table>
</body>
</html>