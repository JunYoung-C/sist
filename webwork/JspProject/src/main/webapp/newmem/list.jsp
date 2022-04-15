<%@page import="java.text.SimpleDateFormat"%>
<%@page import="newmem.NewmemDto"%>
<%@page import="java.util.List"%>
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
<style type="text/css">
div.memberlist table{
	width: 800px;
	border: 2px solid gray;
}

img{
	width: 70px;
	height: 70px;
	border: 1px solid gray;
}

button.log{
	position: absolute;
	left: 700px;
}
</style>
</head>
<body>
<%
NewmemDao dao=new NewmemDao();
List<NewmemDto> list=dao.getAllMembers();
%>

<div class="memberlist">
  <b>총<%=list.size() %>명의 멤버가 있습니다</b>
  <br>
  
  <button type="button" class="btn btn-info log"
  onclick="location.href='../newlog/logoutaction.jsp'">로그아웃</button>
  <br><br>
  <table class="table table-bordered">
    <caption><b>전체 회원 명단</b></caption>
      <tr>
        <th width="50">번호</th>
        <th width="100">아이디</th>
        <th width="100">회원명</th>
        <th width="150">핸드폰</th>
        <th width="150">가입일</th>
        <th width="150">관리</th>
      </tr>
      
      <%
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      int i=1;
      for(NewmemDto dto:list)
      {%>
    	  <tr align="center">
    	    <td><%=i++ %></td>
    	    <td><%=dto.getMid() %></td>
    	    <td>
    	      <img alt="" src="<%=dto.getPhoto()%>" class="img-circle"><br>
    	      <b><%=dto.getName() %></b>
    	    </td>
    	    <td><%=dto.getHp() %></td>
    	     <td><%=sdf.format(dto.getGaip()) %></td>
    	     <td>
    	     
    	     <!-- 회원목록에서 로그인한 본인거만 수정/삭제 버튼 보이게 -->
    	     <%
    	     String loginok=(String)session.getAttribute("loginok");
    	     String mid=(String)session.getAttribute("mid");
    	     
    	     //로그인한 본인거만 나오게
    	     if(loginok!=null && dto.getMid().equals(mid)){
    	    	 %>
    	    	 <button type="button" class="btn btn-info btn-xs"
    	       onclick="location.href='../newmem/updateform.jsp?num=<%=dto.getNum()%>'">수정</button>
    	       <button type="button" class="btn btn-danger btn-xs"
    	       onclick="location.href=''">삭제</button>
    	     <%}else{%>
    	    	 
    	    	 <h5>권한 없음</h5>
    	     <%}
    	     
    	     %>
    	       
    	     </td>
    	    
    	  </tr>
      <%}
      %>
  </table>
</div>
</body>
</html>