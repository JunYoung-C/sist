<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>two파일 전달_한글전달</h3>
<%
request.setCharacterEncoding("utf-8");
%>

<jsp:include page="twoInclude_08.jsp">
  <jsp:param value="이수연" name="name"/>
  <jsp:param value="서울시 강남구 쌍용교육센터" name="addr"/>
</jsp:include>
</body>
</html>