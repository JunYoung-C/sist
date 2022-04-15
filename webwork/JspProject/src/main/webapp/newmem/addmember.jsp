<%@page import="newmem.NewmemDto"%>
<%@page import="newmem.NewmemDao"%>
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
String realPath=getServletContext().getRealPath("/save");
int uoloadSize=1024*1024*2;

MultipartRequest multi=null;
try{
multi=new MultipartRequest(request,realPath,uoloadSize,"utf-8",
		new DefaultFileRenamePolicy());

//dao선언
NewmemDao dao=new NewmemDao();

//dto선언
NewmemDto dto=new NewmemDto();
dto.setMid(multi.getParameter("mid"));
dto.setPass(multi.getParameter("pass"));
dto.setName(multi.getParameter("name"));
dto.setHp(multi.getParameter("hp"));

String photo=multi.getFilesystemName("photo");
if(photo==null)
	dto.setPhoto("../img/4.png"); //사진선택안한경우
else
	dto.setPhoto("../save/"+photo); //선택한 사진

	
	//db 호출
	dao.insertNewmem(dto);
	
	//성공후 이동
	response.sendRedirect("list.jsp"); 
	System.out.println(realPath);

}catch(Exception e){
	
	System.out.println("업로드 오류"+e.getMessage());
}
%>
</body>
</html>