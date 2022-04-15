<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
MemberDao dao=new MemberDao();
List<MemberDto> list=dao.getAllMembers();
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
int no=1;
%>

<table class="table table-bordered" style="width: 900px;">
  <caption><b>전체회원목록</b></caption>
    <tr bgcolor="#ccf">
      <th width="50">번호</th>
      <th width="70">회원명</th>
      <th width="70">아이디</th>
      <th width="120">핸드폰</th>
      <th width="200">주소</th>
      <th width="150">이메일</th>
      <th width="150">가입일</th>
      <th width="100">수정/삭제</th>
    </tr>
    
    <%
    for(MemberDto dto:list)
    {%>
    	<tr>
    	  <td><%=no++ %></td>
    	  <td><%=dto.getName() %></td>
    	  <td><%=dto.getId() %></td>
    	  <td><%=dto.getHp() %></td>
    	  <td><%=dto.getAddr() %></td>
    	  <td><%=dto.getEmail() %></td>
    	  <td><%=sdf.format(dto.getGaipday()) %></td>
    	  <td>
    	     <button type="button" class="btn btn-info btn-xs"
    	     onclick="location.href='index.jsp?main=member/updatepassform.jsp?num=<%=dto.getNum()%>'">수정</button>
    	     <button type="button" class="btn btn-danger btn-xs"
    	     onclick="delfunc(<%=dto.getNum()%>)">삭제</button>
    	  </td>
    	</tr>?
    <%}
    %>
    
    
</table>

<!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-sm" >
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">삭제확인</h4>
        </div>
        
        
        <div class="modal-body">
        	<input type="hidden" id="delnum">
          <b>삭제비밀번호: </b>
            <input type="password" id="delpass" class="form-control" style="width: 120px;">
        </div>
        
        
        <div class="modal-footer">
          <button type="button" class="btn btn-default delbtn" data-dismiss="modal">삭제</button>
        </div>
      </div>
      
    </div>
  </div>


<script type="text/javascript">
  function delfunc(num){
	  //alert(num);
	  $("#delnum").val(num);
	  $("#myModal").modal();
	  
	  
	  
	  //삭제버튼 이벤트
	  $("button.delbtn").click(function(){
		  
		  //num.pass읽기
		  var num=$("#delnum").val();
		  var pass=$("#delpass").val();
		  //삭제파일 호출
		  location.href="member/memberdelete.jsp?num="+num+"&pass="+pass;
	  });
	  
  }

</script>


</body>
</html>