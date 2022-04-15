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

//실제경로
String realPath=getServletContext().getRealPath("/save");
System.out.println(realPath);

int uploadSize=1024*1024*2;

MultipartRequest multi=null;

try{
multi=new MultipartRequest(request,realPath,uploadSize,"utf-8",
		new DefaultFileRenamePolicy());


String num=multi.getParameter("num");
//기존의 포토명 읽어오기
GuestDao dao=new GuestDao();
String old_photoname=dao.getData(num).getPhotoname();

//request아니고 multi로 모든 폼데이터 읽어온다
String content=multi.getParameter("content");
String photoname=multi.getFilesystemName("photo"); 

//페이지 읽기
String currentPage=multi.getParameter("currentPage");

//dto에 저장
GuestDto dto=new GuestDto();

dto.setNum(num);
dto.setContent(content);


//사진선택 안했을경우 기존사진 으로 저장
dto.setPhotoname(photoname==null?old_photoname:photoname);

//update
dao.updateGuest(dto);

//방명록리스트로 이동
response.sendRedirect("../index.jsp?main=guest/guestlist.jsp?currentPage="+currentPage);

}catch(Exception e){
	
}
%>
</body>
</html>