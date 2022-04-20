<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
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
img.photo{
	width: 70px;
	height: 80px;
	border: 1px solid gray;
}

div.sangpum{cursor: pointer;}
span.del{
  cursor: pointer;
}
</style>

<script type="text/javascript">
$(function(){
	
	//전체 체크박스 선택/해제
	$("#allcheck").click(function(){
		
		var a=$(this).is(":checked");
		if(a){
			$(".idx").attr("checked",true); //.prop속성도 됨
		}else{
			$(".idx").attr("checked",false);
		}
	});
	
	//상품클릭시 디테일 페이지로 이동
	$("div.sangpum").click(function(){
		var shopnum=$(this).attr("shopnum");
		
		location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+shopnum;
	});
	
	//선택한 상품 1개삭제 이벤트
	$("span.del").click(function(){
		var idx=$(this).attr("idx");
		var a=confirm("삭제하려면[확인]버튼을 클릭하세요");
		if(a){
					
			//alert(idx);
			//삭제이벤트
			$.ajax({
				
				type:"get",
				url:"shop/cartdelete.jsp",
				dataType:"html",
				data:{"idx":idx},
				success:function(){
					//alert("삭제성공");
					location.reload();//현재페이지 새로고침
				}
				
			});
			
		}
	});
	
	
	//체크한후 삭제버튼으로 삭제이벤트
	$("#btncartdel").click(function(){
		
		//체크한 상품개수
		var cnt=$(".idx:checked").length;
		//alert(cnt);
		if(cnt==0){
			alert("먼저 선택할 상품을 선택하세요");
			return;//함수종료
		}
		
		$(".idx:checked").each(function(i,element){
			
			var idx=$(this).attr("idx");
			console.log(idx); //선택한 상품 idx만 나오는지 반드시 확인
			
			//선택한 장바구니 모두삭제
				$.ajax({
				
				type:"get",
				url:"shop/cartdelete.jsp",
				dataType:"html",
				data:{"idx":idx},
				success:function(){
					//alert("삭제성공");
					location.reload();//현재페이지 새로고침
				}
				
			});
		});
		
	});
	
	
});



</script>


<title>Insert title here</title>
</head>
<%
//로그인한 아이디 얻기
String id=(String)session.getAttribute("myid");

//dao
ShopDao dao=new ShopDao();
//장바구니 목록
List<HashMap<String,String>> list=dao.getCartList(id);
%>
<body>
<h4 class="alert alert-warning" style="width: 1000px;">
<%=id %>님의 장바구니
</h4>

<table class="table table-striped" style="width: 1000px;">
	<tr>
	  <th style="width: 30px;">
	    <input type="checkbox" id="allcheck">
	  </th>
	  <th style="width: 400px;">상품정보</th>
	  <th style="width: 200px;">상품금액</th>
	</tr>
	
	<%
	
	int allmoney=0;
	NumberFormat nf=NumberFormat.getInstance();
	
	
	for(int i=0;i<list.size();i++)
	{
		HashMap<String,String> map=list.get(i);
		int cnt=Integer.parseInt(map.get("cnt"));
		%>
		
		<tr>
		  <td align="center">
		    <input type="checkbox" name="idx" idx="<%=map.get("idx")%>" class="idx"
		    checked="checked">
		  </td>
		  <td>
		    <div shopnum="<%=map.get("shopnum") %>" class="sangpum">
		       <img alt="" src="shopsave/<%=map.get("photo")%>" class="photo"
		       align="left" hspace="20">
		       
		       <h5><b>상품명: <%=map.get("sangpum") %></b></h5>
		       <h5><b>갯수: <%=cnt %></b></h5>
		       <h5><b>날짜: <%=map.get("cartday") %></b></h5>
		       
		    </div>
		  </td>
		  
		  <td align="right" style="padding-right: 300px; vertical-align: middle;" >
		    <%
		     int price=Integer.parseInt(map.get("price"))*cnt;
		    allmoney+=price;
		    %>
		    <h4><%=nf.format(price) %>원
		       <span class="del glyphicon glyphicon-trash" idx="<%=map.get("idx")%>"
		       style="padding-left: 50px; color: green;"></span>
		     
		    </h4>
		  </td>
		</tr>
	<%}
	%>
	
	<tr>
	  <td colspan="3">
	    <button type="button" class="btn btn-danger btn-lg"
	    style="margin-left: 100px;" id="btncartdel">선택상품삭제</button>
	    
	    <span style="font-size: 2em; float: right; ">총 주문금액:  <b style="color: green;"><%=nf.format(allmoney) %>원</b></span>
	  </td>
	</tr>
	
	
	
</table>
</body>
</html>