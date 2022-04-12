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
<form action="addmember.jsp" method="post" enctype="multipart/form-data" 
class="form-inline" name="mfrm">
  <table class="table table-bordered" style="width: 500px">
    <caption><b>회원가입</b></caption>
    <tr>
      <td bgcolor="#66cdaa" width="120">아이디</td>
      <td>
        <input type="text" class="form-control input-sm" style="width: 120px; background-color: gray"
        readonly="readonly" name="mid" required="required">
      </td>
    </tr>
  </table>  
  
</form>
</body>
</html>