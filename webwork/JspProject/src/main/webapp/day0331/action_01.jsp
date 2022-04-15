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
request.setCharacterEncoding("utf-8");

String grade=request.getParameter("grade");
String[] lang=request.getParameterValues("lang");
String file=request.getParameter("file");
String semi=request.getParameter("semi");
String height=request.getParameter("height");
String weight=request.getParameter("weight");
String col=request.getParameter("col");
String naljja=request.getParameter("naljja");
%>

<h3>**신상정보**</h3>
학력: <b><%=grade %></b><br>
가능한 언어:<br>
<%
if(lang==null)
{%>
	<font color="blue">아무것도 못합니다~~<br></font>
<%}else
{
	for(int i=0;i<lang.length;i++)
	{%>
		&nbsp;&nbsp;&nbsp;<b><%=lang[i] %></b><br>
	<%}
}
%>
파일명:<b><%=file %></b><br>
쎄미1등조:<b><%=semi %></b><br>
키:<b><%=height %></b><br>
몸무게:<b><%=weight %></b><br>
색상:<b><%=col %></b><br>
날짜:<b><%=naljja %></b><br>
</body>
</html>