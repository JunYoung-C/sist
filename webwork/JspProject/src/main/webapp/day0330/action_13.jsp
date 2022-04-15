<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.box{

float: left;
width: 50px;
height: 50px;
border-radius: 100px;
margin-right: 10px;
}
</style>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");

String sang=request.getParameter("sang");
String [] scolor=request.getParameterValues("scolor");
String ssize=request.getParameter("ssize");
String chuga=request.getParameter("chuga");
%>

<h3>상품명: <%=sang %></h3>
<h3>상품색상: <br>

<%
	if(scolor==null){%>
		
		<b>선택한 색상 없음</b>
	<%}else{
		for(String s:scolor){%>
			
			<div style="background-color: <%=s%>" class="box"></div>
		<%}
	}
%>


</h3><br><br>

<h3>사이즈: <%=ssize %></h3>
<h3>추가상품: <%=chuga %></h3>

</body>
</html>