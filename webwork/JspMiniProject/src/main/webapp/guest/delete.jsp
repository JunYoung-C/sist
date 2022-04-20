<%@page import="java.io.File"%>
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
</head>
<body>
<%
//주의:db삭제포함 업로드된 파일도 삭제
String num=request.getParameter("num");
String currentPage=request.getParameter("currentPage");

//db로부터 저장된 이미지명 얻기
GuestDao dao=new GuestDao();
String photoname=dao.getData(num).getPhotoname();

//db삭제
dao.deleteGuest(num);

//프로젝트 실제경로
String realPath=getServletContext().getRealPath("/save");

//파일객체생성
File file=new File(realPath+"\\"+photoname);
//파일삭제
file.delete();

//보던페이지로 이동
response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);

%>
</body>
</html>