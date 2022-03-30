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
  String[] colors = {"green", "magenta", "yellow", "cyan", "orange"};
  String title = "배열 출력";
  %>

  <table class="table table-bordered" style="width: 200px">
    <caption>
      <b><%=title%></b>
    </caption>
    <tr bgcolor="pink">
      <th>번호</th>
      <th>색상</th>
    </tr>

    <%
    for (int i = 0; i < colors.length; i++) {
    %>

    <tr>
      <td><%=i + 1%></td>
      <td><b style="color: <%=colors[i]%>"><%=colors[i]%></b></td>
    </tr>

    <%
    }
    %>
  </table>
</body>
</html>