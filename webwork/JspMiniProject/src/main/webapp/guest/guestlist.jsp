<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.List"%>
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
<title>Insert title here</title>
<style type="text/css">
span.day{
	float: right;
	font-size: 11pt;
	color: gray;
}
</style>
</head>
<%
//로그인상태 확인후 입력폼 나타내기
String loginok=(String)session.getAttribute("loginok");

//dao선언
GuestDao dao=new GuestDao();

//페이징처리에 필요한 변수
int totalCount; //총글수
int totalPage; //총 페이지수
int startPage; //각블럭의 시작페이지
int endPage; //각블럭의 끝페이지
int start; //각페이지의 시작번호
int perPage=3; //한페이지에 보여질 글 갯수
int perBlock=5; //한블럭당 보여지는 페이지 개수
int currentPage; //현재페이지 번호



//총갯수
totalCount=dao.getTotalCount();

//현재 페이지번호 읽기(단 null일경우는 1페이지로 설정)
if(request.getParameter("currentPage")==null)
	currentPage=1;
else
	currentPage=Integer.parseInt(request.getParameter("currentPage"));

//총페이지 개수구하기
totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

//각블럭의 시작페이지
//예:현재페이지가 3인경우 startpage=1,endpage= 5
//현재페이지가 6인경우 startpage=6,endpage= 10
startPage=(currentPage-1)/perBlock*perBlock+1;
endPage=startPage+perBlock-1;

//만약 총페이지가 8 -2번째블럭: 6-10 ..이럴경우는 endpage가 8로 수정되어야함
if(endPage>totalPage)
	endPage=totalPage;

//각페이지에서 불러올 시작번호
start=(currentPage-1)*perPage;

//각페이지에서 필요한 게시글 가져오기
List<GuestDto> list=dao.getList(start, perPage);

SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>
<body>
<%
if(loginok!=null){%>
	
	<jsp:include page="guestform.jsp"/>
	<hr align="left" width="700">
<%}
%>

<!-- <b>방명록 리스트 출력</b> -->
<div>
  <b>총 <%=totalCount %>개의 방명록 글이 있습니다</b>
<%
MemberDao mdao=new MemberDao();
for(GuestDto dto:list)
{
	//이름얻기
	String name=mdao.getName(dto.getMyid());
	%>
	
	<table class="table table-bordered" style="width:600px; ">
	  <tr>
	    <td>
	      <b><span class="glyphicon glyphicon-user"></span><%=name %>(<%=dto.getMyid() %>)</b>
	      <%
	      //로그인한 아이디
	      String myid=(String)session.getAttribute("myid");
	      //로그인한 아이디와 글을쓴아이디가 같을때만 수정,삭제되게 한다
	      if(loginok!=null && dto.getMyid().equals(myid)){%>
	    	  
	    	  |<a href="index.jsp?main=guest/updateform.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>" >수정</a>
	    	  |<a href="">삭제</a>
	      <%}
	      
	      %>
	      <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
	    </td>
	  </tr>
	  
	  <tr height="120">
	    <td>
	      <a href="save/<%=dto.getPhotoname()%>" target="_blank">
	         <img alt="" src="save/<%=dto.getPhotoname()%>" align="left"
	         style="width: 150px; margin-right: 20px;">
	      </a>
	      <%=dto.getContent().replace("\n", "<br>") %>
	    </td>
	  </tr>
	  
	  <!-- 댓글,추천 -->
	  <tr>
	     <td>
	       <span class="answer" style="cursor: pointer;" num=<%=dto.getNum() %>>댓글 0</span>
	       <span class="likes" style="cursor: pointer;" num=<%=dto.getNum() %>>추천</span>
	       <span class="chu"><%=dto.getChu() %></span>
	     </td>
	  </tr>
	</table>
<%}

%>
</div>

<!-- 페이징처리 -->

<div style="width: 600px; text-align: center;">
  <ul class="pagination">
  	
  	<%
  	//이전
  	if(startPage>1)
  	{%>
  		<li>
  		  <a href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=startPage-1%>">이전</a>
  		</li>
  	<%}
  	
  	for(int pp=startPage;pp<=endPage;pp++)
  	{
  		if(pp==currentPage)
  		{%>
  			<li class="active">
  			  <a href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
  			</li>
  		<%}else{%>
  			<li >
  			  <a href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
  			</li>
  		<%}
  	}
  	
  	//다음
  	if(endPage<totalPage)
  	{%>
  		<li>
  		  <a href="index.jsp?main=guest/guestlist.jsp?currentPage=<%=endPage+1%>">다음</a>
  		</li>
  	<%}
  	%>
  	
  </ul>
</div>

</body>
</html>