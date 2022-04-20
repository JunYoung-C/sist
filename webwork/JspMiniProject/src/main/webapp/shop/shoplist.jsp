<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="java.text.NumberFormat"%>
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
<style type="text/css">
 img.photo{
 	width: 200px;
 	height: 230px;
 	border: 1px solid gray;
 	margin-bottom: 10px;
 }
 
 .shoptb tr{
 	height: 280px;
 	font-weight: bold;
 	padding: 10px;
 }
</style>

<script type="text/javascript">
$(function(){
	
	$("a.godetail").click(function(){
		
		//태그에 넣어둔 shopnum
		var shopnum=$(this).attr("shopnum");
		//alert(shopnum);
		
		location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+shopnum;
	});
});
</script>

<title>Insert title here</title>
</head>
<%
ShopDao dao=new ShopDao();
List<ShopDto> list=dao.getAllSangpums();
%>
<body>

<div class="container">
  <h2>Dynamic Tabs</h2>
  <ul class="nav nav-tabs">
    <li class="active"><a data-toggle="tab" href="#전체">전체상품</a></li>
    <li><a data-toggle="tab" href="#뷰티">뷰티</a></li>
    <li><a data-toggle="tab" href="#패션잡화">패션잡화</a></li>
    <li><a data-toggle="tab" href="#생활">생활</a></li>
  </ul>

  <div class="tab-content">

   <div id="전체" class="tab-pane fade in active">
      <h3>전체상품</h3>
    <p>
      <table class="shoptb table table-bordered" style="width: 700px;">
         
         <tr>
         <%
           NumberFormat nf=NumberFormat.getCurrencyInstance();
         int i=0;
         for(ShopDto dto:list)
         {
        	 //사진
        	 String photo=dto.getPhoto();
        	 //할인율20~50난수발생
        	 int sale=(int)(Math.random()*31)+20;
        	 %>
        	 <td>
        	   <a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
        	     <img alt="" src="shopsave/<%=photo%>" class="photo">
        	     <br>
        	     <%=dto.getSangpum() %><br>
        	     <b style="color: red; font-size: 1.3em;"><%=sale %>%</b>
        	     <span style="float: right;">
        	       <div style="color: gray; font-size: 13pt;">
        	         <%
        	         	int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
        	         %>
        	         <strike><%=nf.format(price) %></strike>
        	       </div>
        	       <div style="color: black; font-size: 16px;">
        	         <%=nf.format(dto.getPrice()) %>
        	       </div>
        	     </span>
        	   </a>
        	 </td>
        	 <%
        	 if((i+1)%5==0)
        	 {%>
        		 </tr>
        		 <tr>
        	 <%}
        	i++;
         }
         %>
         </tr>
      </table>
    </p>
  </div> 

<div id="뷰티" class="tab-pane fade in active">
      <h3>뷰티</h3>
    <p>
      <table class="shoptb table table-bordered" style="width: 700px;">
         
         <tr>
         <%
          
       i=0;
         for(ShopDto dto:list)
         {
        	 
        	 if(dto.getCategory().equals("뷰티"))
        	 {
        	 //사진
        	 String photo=dto.getPhoto();
        	 //할인율20~50난수발생
        	 int sale=(int)(Math.random()*31)+20;
        	 %>
        	 <td>
        	   <a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
        	     <img alt="" src="shopsave/<%=photo%>" class="photo">
        	     <br>
        	     <%=dto.getSangpum() %><br>
        	     <b style="color: red; font-size: 1.3em;"><%=sale %>%</b>
        	     <span style="float: right;">
        	       <div style="color: gray; font-size: 13pt;">
        	         <%
        	         	int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
        	         %>
        	         <strike><%=nf.format(price) %></strike>
        	       </div>
        	       <div style="color: black; font-size: 16px;">
        	         <%=nf.format(dto.getPrice()) %>
        	       </div>
        	     </span>
        	   </a>
        	 </td>
        	 <%
        	 if((i+1)%5==0)
        	 {%>
        		 </tr>
        		 <tr>
        	 <%}
        	i++;
        	 }
         }
         %>
         </tr>
      </table>
    </p>
  </div>
  
  <div id="패션잡화" class="tab-pane fade in active">
      <h3>패션잡화</h3>
    <p>
      <table class="shoptb table table-bordered" style="width: 700px;">
         
         <tr>
         <%
          
       i=0;
         for(ShopDto dto:list)
         {
        	 
        	 if(dto.getCategory().equals("패션잡화"))
        	 {
        	 //사진
        	 String photo=dto.getPhoto();
        	 //할인율20~50난수발생
        	 int sale=(int)(Math.random()*31)+20;
        	 %>
        	 <td>
        	   <a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
        	     <img alt="" src="shopsave/<%=photo%>" class="photo">
        	     <br>
        	     <%=dto.getSangpum() %><br>
        	     <b style="color: red; font-size: 1.3em;"><%=sale %>%</b>
        	     <span style="float: right;">
        	       <div style="color: gray; font-size: 13pt;">
        	         <%
        	         	int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
        	         %>
        	         <strike><%=nf.format(price) %></strike>
        	       </div>
        	       <div style="color: black; font-size: 16px;">
        	         <%=nf.format(dto.getPrice()) %>
        	       </div>
        	     </span>
        	   </a>
        	 </td>
        	 <%
        	 if((i+1)%5==0)
        	 {%>
        		 </tr>
        		 <tr>
        	 <%}
        	i++;
        	 }
         }
         %>
         </tr>
      </table>
    </p>
  </div>
  
  <div id="생활" class="tab-pane fade in active">
      <h3>생활</h3>
    <p>
      <table class="shoptb table table-bordered" style="width: 700px;">
         
         <tr>
         <%
          
       i=0;
         for(ShopDto dto:list)
         {
        	 
        	 if(dto.getCategory().equals("생활"))
        	 {
        	 //사진
        	 String photo=dto.getPhoto();
        	 //할인율20~50난수발생
        	 int sale=(int)(Math.random()*31)+20;
        	 %>
        	 <td>
        	   <a shopnum="<%=dto.getShopnum() %>" style="cursor: pointer;" class="godetail">
        	     <img alt="" src="shopsave/<%=photo%>" class="photo">
        	     <br>
        	     <%=dto.getSangpum() %><br>
        	     <b style="color: red; font-size: 1.3em;"><%=sale %>%</b>
        	     <span style="float: right;">
        	       <div style="color: gray; font-size: 13pt;">
        	         <%
        	         	int price=(int)(dto.getPrice()+(dto.getPrice()*(sale/100.0)));
        	         %>
        	         <strike><%=nf.format(price) %></strike>
        	       </div>
        	       <div style="color: black; font-size: 16px;">
        	         <%=nf.format(dto.getPrice()) %>
        	       </div>
        	     </span>
        	   </a>
        	 </td>
        	 <%
        	 if((i+1)%5==0)
        	 {%>
        		 </tr>
        		 <tr>
        	 <%}
        	i++;
        	 }
         }
         %>
         </tr>
      </table>
    </p>
  </div>
  
  </div>
  </div>

</body>
</html>