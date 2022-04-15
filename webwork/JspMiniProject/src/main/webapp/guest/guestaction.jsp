<%@page import="data.dao.GuestDao"%>
<%@page import="data.dto.GuestDto"%>
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
//세션으로부터 db저장할 id
String myid=(String)session.getAttribute("myid");

//실제경로
String realPath=getServletContext().getRealPath("/save");
System.out.println(realPath);

int uploadSize=1024*1024*2;

MultipartRequest multi=null;

try{
multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());

//request아니고 multi로 모든 폼데이터 읽어온다
String content=multi.getParameter("content");
String photoname=multi.getFilesystemName("photo"); 

//dto에 저장
GuestDto dto=new GuestDto();
dto.setMyid(myid);
dto.setContent(content);
dto.setPhotoname(photoname);

//dao선언
GuestDao dao=new GuestDao();
//insert
dao.insertGuest(dto);

//방명록리스트로 이동
response.sendRedirect("../index.jsp?main=guest/guestlist.jsp");

}catch(Exception e){
	
}
%>
</body>
</html>