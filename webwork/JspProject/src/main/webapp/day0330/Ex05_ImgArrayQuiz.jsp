<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<!-- jQuery library -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  int n = 1;
  %>


  <table class="table table-bordered" style="width: 500px">
    <%
    for (int i = 0; i < 4; i++) {
    %>

    <tr>
      <%
      for (int j = 0; j < 5; j++) {
      %>

      <td><img alt="" src="../image/avata/<%=n++%>.png" style="width: 100px; height: 100px"></td>

      <%
      }
      %>
    </tr>

    <%
    }
    %>
  </table>
</body>
</html>