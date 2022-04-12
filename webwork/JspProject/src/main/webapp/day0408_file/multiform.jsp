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
  <form action="multiproc.jsp" method="post"
    enctype="multipart/form-data">
    <table class="table table-hover" style="width: 500px;">
      <caption>
        <b>여러개 이미지 업로드</b>
      </caption>
      <tr>
        <th width="100" bgcolor="pink">작성자</th>
        <td><input type="text" name="writer" class="form-control" style="width: 120px"></td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="pink">이미지</th>
        <td>
          <input type="file" name="photo1" class="form-control">
          <input type="file" name="photo2" class="form-control">
          <input type="file" name="photo3" class="form-control">
        </td>
      </tr>

      <tr>
        <td colspan="2" align="center">
          <button type="submit" class="btn btn-info">서버에 업로드 하기</button>
        </td>
      </tr>
    </table>
  </form>
</body>
</html>