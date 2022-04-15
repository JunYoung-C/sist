<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
span.camera{
  font-size: 1.3em;
  cursor: pointer;
  margin-left: 30px;
}
</style>

<script type="text/javascript">
  $(function(){
	  
	  $("span.camera").click(function(){
		  
		  $("#photo").trigger("click"); //이벤트 강제호출
	  });
	  
  });
  
  //이미지 미리보기 함수
  function readURL(input) {
	if (input.files && input.files[0]) {
	var reader = new FileReader();

	reader.onload = function (e) {
	$("#showimg")
	.attr('src', e.target.result);
	};
	reader.readAsDataURL(input.files[0]);
}
}
  
</script>
<title>Insert title here</title>
</head>
<%
//num,페이지번호
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");

GuestDao dao=new GuestDao();
GuestDto dto=dao.getData(num);

%>
<body>
<div>

<!-- 이미지 미리보기 위치 -->
<img id="showimg" style="position: absolute; left: 800px; top: 100px; max-width: 100px;">

<form action="guest/updateaction.jsp" method="post" enctype="multipart/form-data"
class="form-inline">

<!-- hidden -->
<input type="hidden" name="num" value="<%=num%>">
<input type="hidden" name="currentPage" value="<%=currentPage%>">

  <table class="table table-bordered" style="width: 600px;">
    <caption><b>방명록 수정</b>
      <span class="glyphicon glyphicon-camera camera"></span>
      <input type="file" name="photo" id="photo" style="visibility: hidden;"
      onchange="readURL(this)" >
    </caption>
    
    
    <tr height="100">
      <td width="500">
         <textarea style="width: 480px; height: 100px;"
         class="form-control" name="content" required="required"><%=dto.getContent() %></textarea>
      </td>
      
      <td>
        <button type="submit" class="btn btn-default"
        style="width: 100px; height: 100px;">수정</button>
      </td>
    </tr>
  </table>
</form>
</div>
</body>
</html>