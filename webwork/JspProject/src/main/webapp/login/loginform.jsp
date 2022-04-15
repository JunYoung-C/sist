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

//세션으로 부터 아이디저장 체크값,아이디를 얻는다
String saveok=(String)session.getAttribute("saveok");
String id=(String)session.getAttribute("idok");
%>
<body>
<form action="loginproc.jsp" method="post">
  <table class="table table-bordered" style="width: 250px;">
    <caption><b>세션로그인</b></caption>
      <tr height="30">
        <td colspan="2" style="padding-left: 10px;">
        
        <%
        if(saveok==null)
        {%>
        	<input type="checkbox" name="savechk">아이디저장
        <%}else //체크상태이면?
        {%>
        	<input type="checkbox" name="savechk" checked="checked">아이디저장
        <%}
        %>
        
          
          <b>보안로그인</b>
        </td>
      </tr>
      <tr height="30">
         <th width="80">아이디</th>
           <td>
           
           <%
           if(saveok==null)
           {%>
        	   <input type="text" size="10" name="id"
             autofocus="autofocus" value="">
           <%}else  //체크상태면?
           {%>
        	   <input type="text" size="10" name="id"
             autofocus="autofocus" value="<%=id%>">
           <%}
           %>
           
             
           </td>
      </tr>
      
      <tr height="30">
         <th width="80">비밀번호</th>
           <td>
             <input type="password" size="10" name="pass"
              required="required" class="form=control">
           </td>
      </tr>
      
      <tr height="30">
        <td colspan="2" align="center">
          <input type="submit" value="로그인" class="btn btn-info">
          <input type="button" value="회원가입" onclick="" class="btn  btn-danger">
        </td>
      </tr>
    
  </table>
</form>
</body>
</html>