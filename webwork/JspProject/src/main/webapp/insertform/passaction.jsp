<%@page import="sinsang.SinsangDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
      href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
      rel="stylesheet"
    />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String pass = request.getParameter("pass");

if (pass.equals("a1234")) {
  String num = request.getParameter("num");
  SinsangDao dao = new SinsangDao();
  dao.deleteSinsang(num);

  response.sendRedirect("sslist.jsp");
} else {
  %>
  <script type="text/javascript">
  alert("비밀번호가 맞지 않습니다.");
  history.back();
  </script>
  <%
}
%>
</body>
</html>