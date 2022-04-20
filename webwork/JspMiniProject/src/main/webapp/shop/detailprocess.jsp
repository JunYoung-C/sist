<%@page import="data.dto.CartDto"%>
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
<title>Insert title here</title>
</head>
<body>
<%-- <%
request.setCharacterEncoding("utf-8");

String shopnum=request.getParameter("shopnum");
String num=request.getParameter("num");
int cnt=Integer.parseInt(request.getParameter("cnt"));

CartDto dto=new CartDto();
dto.setShopnum(shopnum);
dto.setNum(num);
dto.setCnt(cnt);

ShopDao dao=new ShopDao();
dao.insertCart(dto);
%> --%>

<jsp:useBean id="dao" class="data.dao.ShopDao"/>
<jsp:useBean id="dto" class="data.dto.CartDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
dao.insertCart(dto);
%>

</body>
</html>