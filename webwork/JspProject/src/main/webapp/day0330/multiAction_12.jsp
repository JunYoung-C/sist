<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("Utf-8");
String city=request.getParameter("city");
String [] city2=request.getParameterValues("city2");
%>
<h2>희망지역</h2>

1순위: <%=city %><br><br>
2순위:

<%
if(city2==null)
{%>
	<font color="red">지역선택 안함</font>
<%}else
{
	for(int i=0;i<city2.length;i++)
	{%>
		
		[<%=city2[i] %>]&nbsp;
	<%}%>
	
	<b>총<%=city2.length %>개 지역 선택함</b><br>
<%}
%>
<br>
<a href="selectForm_12.html">다시입력</a><br>
<a href="javascript:history.back()">다시입력</a>
</body>
</html>