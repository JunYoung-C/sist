<%@page import="data.dao.ShopDao"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
//실제경로
String realPath=getServletContext().getRealPath("/shopsave");
System.out.println(realPath);

int uploadSize=1024*1024*2;

MultipartRequest multi=null;

try{
multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());

//request아니고 multi로 모든 폼데이터 읽어온다
String sangpum=multi.getParameter("sangpum");
String category=multi.getParameter("category");
String ipgoday=multi.getParameter("ipgoday");
int price=Integer.parseInt(multi.getParameter("price"));
String photo=multi.getFilesystemName("photo"); 

//dto에 저장
ShopDto dto=new ShopDto();
dto.setSangpum(sangpum);
dto.setCategory(category);
dto.setIpgoday(ipgoday);
dto.setPhoto(photo);
dto.setPrice(price);


//dao선언
ShopDao dao=new ShopDao();
//insert
dao.insertShop(dto);

//상품등록
response.sendRedirect("../index.jsp?main=shop/addform.jsp");

}catch(Exception e){
	
}
%>
</body>
</html>