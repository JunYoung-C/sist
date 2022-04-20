<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="data.dto.ShopDto"%>
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
img.large{
	width: 400px;
	height: 450px;
}
</style>
<title>Insert title here</title>
</head>
<%

String shopnum=request.getParameter("shopnum");

//로그인상태
String loginok=(String)session.getAttribute("loginok");
//로그인한 아이디
String myid=(String)session.getAttribute("myid");

//아이디에 해당하는 멤버테이블의 시퀀스번호(num)
MemberDao mdao=new MemberDao();
String num=mdao.getNum(myid);

//해당상품 하나의 데이타 가져온거..디테일페이지
ShopDao sdao=new ShopDao();
ShopDto dto=sdao.getData(shopnum);
%>
<body>
<form id="frm">
  <input type="hidden" name="shopnum" value="<%=shopnum%>">
  <input type="hidden" name="num" value="<%=num%>">
     <table style="width: 800px;">
     <tr>
       <td style="width: 500px;">
       <div >
         <img alt="" src="shopsave/<%=dto.getPhoto()%>" class="large img-thumbnail">
       </div>
       </td>
       <td style="width: 300px;" valign="top">
          <h3>카테고리:  <%=dto.getCategory() %></h3>
          <h3>상품명: <%=dto.getSangpum() %></h3>
          <%
          NumberFormat nf=NumberFormat.getCurrencyInstance();
           %>
           <h3>가격: <%=nf.format(dto.getPrice()) %></h3>
           
           
           <h3>갯수: 
             <input type="number" min="1" max="10" value="1" step="1" name="cnt">
           </h3>
           
           <div style="margin-top: 200px; margin-left: 60px;">
             <button type="button" class="btn btn-success"
             id="btncart">장바구니</button>
             <button type="button" class="btn btn-success"
             onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
           </div>
           
       </td>
     </tr>
     
     </table>

</form>

<script type="text/javascript">
$("#btncart").click(function(){
	
	var login="<%=loginok%>";
	if(login=="null"){
		alert("먼저 로그인을 해주세요");
		return;
	}
	
	//form태그의 모든것 가죠오기
	var formdata=$("#frm").serialize();
	//alert(formdata);
	
	//ajax처리한다(성공시 alert("성공") 또는 mycart로 링크  )
	$.ajax({
		type:"post",
		dataType:"html",
		data:formdata,
		url:"shop/detailprocess.jsp",
		success:function(){
			//alert("성공");
			var a=confirm("장바구니에 저장하였습니다\n장바구니로 이동하려면 [확인]버튼을 눌러주세요");
			if(a){
				location.href="index.jsp?main=shop/mycart.jsp";
			}
		}
	});
});

</script>




</body>
</html>