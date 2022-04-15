<%@page import="newmem.NewmemDto"%>
<%@page import="newmem.NewmemDao"%>
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
<%
//num
String num=request.getParameter("num");
//dao에서 num에 해당하는 dto얻기
NewmemDao dao=new NewmemDao();
NewmemDto dto=dao.getData(num);

%>
<body>
<form action="updatemember.jsp" method="post" enctype="multipart/form-data"
class="form-inline" name="mfrm">

<!--hidden num넘기기  -->
<input type="hidden" name="num" value="<%=num%>">

  <table class="table table-bordered" style="width: 500px;">
    <caption><b>회원수정</b></caption>
      <tr>
        <td bgcolor="#66cdaa" width="120">아이디</td>
        <td>
          <b><%=dto.getMid() %></b>
        </td>
      </tr>
      
      
      
      <tr>
        <td bgcolor="#66cdaa" width="120">이름</td>
        <td>
          <input type="text" class="form-control input-sm" style="width: 120px;"
           name="name" value="<%=dto.getName()%>">
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">사진</td>
        <td>
          <input type="file" class="form-control" style="width: 200px;"
           name="photo" >
            <img alt="" src="../<%=dto.getPhoto()%>" width="60" border="1"> 
         
        </td>
      </tr>
      
      <tr>
        <td bgcolor="#66cdaa" width="120">핸드폰</td>
        <td>
          <input type="text" class="form-control input-sm" style="width: 200px;"
           name="hp" value="<%=dto.getHp()%>">
        </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
          <button type="submit" class="btn btn-info" style="width: 150px;">회원정보수정</button>
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