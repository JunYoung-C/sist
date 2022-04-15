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
<%
  String [] str={"a.png","a01.png","a02.png","a03.png","a04.png","a05.png","a06.png","acc01.png","acc02.png"};

	int n=0;  //증가변수
%>

<table class="table table-bordered" style="width: 500px;">
   <%
   for(int i=0;i<3;i++)  //행
   {%>
	   <tr>
	      <%
	      for(int j=0;j<3;j++) //열
	      {%>
	    	  <td>
	    	     <img alt="" src="../image/<%=str[n]%>" width="150px;" height="150px;">
	    	  </td>
	    	  
	      <%
	        n++;
	      }
	      %>
	   </tr>
   <%}
   %>
</table>
</body>
</html>