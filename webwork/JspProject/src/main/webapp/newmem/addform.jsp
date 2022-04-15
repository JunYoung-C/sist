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
<form action="addmember.jsp" method="post" enctype="multipart/form-data"
class="form-inline" name="mfrm">
  <table class="table table-bordered" style="width: 500px;">
    <caption><b>회원가입</b></caption>
      <tr>
        <td bgcolor="#66cdaa" width="120">아이디</td>
        <td>
          <input type="text" class="form-control input-sm" style="width: 120px;"
          readonly="readonly" name="mid" required="required">
          <button type="button" class="btn btn-danger btn-sm"
          onclick="openId()">아이디입력</button>
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">비밀번호</td>
        <td>
          <input type="password" class="form-control input-sm" style="width: 120px;"
           name="pass" required="required">
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">이름</td>
        <td>
          <input type="text" class="form-control input-sm" style="width: 120px;"
           name="name" required="required">
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">사진</td>
        <td>
          <input type="file" class="form-control" style="width: 200px;"
           name="photo" >
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">핸드폰</td>
        <td>
          <input type="text" class="form-control input-sm" style="width: 200px;"
           name="hp" required="required">
        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <button type="submit" class="btn btn-info" style="width: 150px;">회원가입신청</button>
          <button type="button" class="btn btn-success" style="width: 150px;"
          onclick="location.href='list.jsp'">회원목록</button>
        </td>
      </tr>
  </table>
</form>

<script type="text/javascript">
  function openId()
  {
	  window.open('idcheck.jsp',"","left=100px,top=100px,width=300px,height=150px");
  }
</script>
</body>
</html>