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
<body>
<%
String key=request.getParameter("key"); //처음호출시 null값
if(key==null){
	//null값일경우 폼을 나타내고
	%>
	
	<div style="margin: 10px 30px;">
  <form action="idcheck.jsp" method="post" class="form-inline">
    <b>아이디들 입력해 주세요</b><br>
    <input type="text" name="mid" class="form-control input-sm"
    style="width: 130px; float: left;" required="required" placeholder="아이디입력">
    
    <!--key값 넘기기..hidden  -->
      <input type="hidden" name="key" value="yes"> 
    
    <button type="submit" class="btn btn-success btn-sm"
    style="margin-left: 10px;">중복체크</button>
  </form>
</div>
<%}else{
	//action을처리
	String mid=request.getParameter("mid");
	
	//dto선언후 id가 db에 존재하는 지 확인
	NewmemDao dao=new NewmemDao();
	boolean b=dao.isIdCheck(mid);
	if(b){
		//존재하는 경우
		%>
		<div style="margin: 10px 30px;">
		  <h5><%=mid %>는 이미 가입된 아이디 입니다</h5>
		  <img alt="" src="../img/2.png" width="60" align="left">
		  <button type="button" class="btn btn-danger btn-sm"
		  onclick="location.href='idcheck.jsp'">다시입력</button>
		</div>
	<%}else{
		//존재하지 않는경우
		%>
		<div style="margin: 10px 30px;">
		  <h5><%=mid %>는 사용가능한 아이디 입니다</h5>
		  <img alt="" src="../img/5.png" width="60" align="left">
		  <button type="button" class="btn btn-danger btn-sm"
		  onclick="saveId('<%=mid%>')">적용하기</button>
		   <button type="button" class="btn btn-danger btn-sm"
		  onclick="location.href='idcheck.jsp'">다시입력</button>
		  
		</div>
		
	<%}
}
%>

<script type="text/javascript">
  function saveId(id){
	  
	  //alert(id);
	  //부모창: opener
	  opener.mfrm.mid.value=id;
	  //현재창 닫기
	  window.close();
	  
  }
</script>

</body>
</html>