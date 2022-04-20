<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.SmartDao"%>
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
SmartDao db=new SmartDao();


//페이징처리에 필요한 변수
int totalCount; //총글수
int totalPage; //총 페이지수
int startPage; //각블럭의 시작페이지
int endPage; //각블럭의 끝페이지
int start; //각페이지의 시작번호
int perPage=5; //한페이지에 보여질 글 갯수
int perBlock=5; //한블럭당 보여지는 페이지 개수
int currentPage; //현재페이지

int no;

//총갯수
totalCount=db.getTotalCount();

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
List<SmartDto> list=db.getList(start, perPage);

//각 글앞에 붙일 시작번호 구하기
//총글이 20개면? 1페이지 20 2페이지 15부터 출력해서 1씩 감소
no=totalCount-(currentPage-1)*perPage;
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<!--게시판 출력  -->

<button type="button" class="btn btn-success"
style="margin-left: 20px; width: 100px;"
onclick="location.href='index.jsp?main=board/smartform.jsp'"><span class="glyphicon glyphicon-pencil"></span>글추가</button>

<table class="table table-bordered" style="width: 900px;">
  <caption><b>스마트 게시판</b></caption>
    <tr bgcolor="#ddd">
      <th width="70">번호</th>
      <th width="370">제목</th>
      <th width="100">작성자</th>
      <th width="170">작성일</th>
      <th width="70">조회</th>
    </tr>
    
    <%
    if(totalCount==0)
    {%>
    	<tr height="40">
    	  <td colspan="5" align="center">
    	    <b>등록된 게시글이 없습니다</b>
    	  </td>
    	</tr>
    <%}else{
    	for(SmartDto dto:list)
    	{%>
    		<tr>
    		  <td align="center"><%=no-- %></td>
    		  <td>
    		  <a href="index.jsp?main=board/detail.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>">
    		  <%=dto.getSubject() %></a>
    		  
    		  </td>
    		  <td><%=dto.getWriter() %></td>
    		  <td><%=sdf.format(dto.getWriteday()) %></td>
    		  <td><%=dto.getReadcount() %></td>
    		</tr>
    		
    		
    	<%}
    }
    %>
    
    
</table>



<!-- 페이징처리 -->

<div style="width: 500px; text-align: center;" class="container">
  <ul class="pagination">
  	
  	<%
  	//이전
  	if(startPage>1)
  	{%>
  		<li>
  		  <a href="index.jsp?main=board/boardlist.jsp?currentPage=<%=startPage-1%>">이전</a>
  		</li>
  	<%}
  	
  	for(int pp=startPage;pp<=endPage;pp++)
  	{
  		if(pp==currentPage)
  		{%>
  			<li class="active">
  			  <a href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
  			</li>
  		<%}else{%>
  			<li >
  			  <a href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
  			</li>
  		<%}
  	}
  	
  	//다음
  	if(endPage<totalPage)
  	{%>
  		<li>
  		  <a href="index.jsp?main=board/boardlist.jsp?currentPage=<%=endPage+1%>">다음</a>
  		</li>
  	<%}
  	%>
  	
  </ul>
</div>



</body>
</html>