<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
  href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
  rel="stylesheet" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
<!-- jQuery library -->
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
  MultipartRequest multi = null;

  // 톰캣에 업로드된 프로젝트 경로
  ServletContext context = getServletContext();
  //프로젝트의 업로드된 실제 경로
  String realFolder = context.getRealPath("/upload");
  System.out.println("realFolder");

  // 허용할 크기
  int uploadSize = 1024 * 1024 * 3; // 3mb
  try {
    multi =
    new MultipartRequest(request, realFolder, uploadSize, "utf-8", new DefaultFileRenamePolicy());
    
    //입력한 값을 읽어오기
    String writer = multi.getParameter("writer");
    Enumeration formNames = multi.getFileNames();
    
    while (formNames.hasMoreElements()) {
      // 파일 태그에서 name 얻기
      String fileName= (String) formNames.nextElement();
      System.out.println("fileType name: " + fileName);
      
      //실제 업로드된 파일명 얻기
      String uploadFileName = multi.getFilesystemName(fileName);
      
      // 파일 선택 한앴을 경우 null값
      if (uploadFileName != null) {%>
        <img src="../upload/<%= uploadFileName %>" style="max-width: 200px;" border="1">
        <b><%=uploadFileName %></b>
        <%
      }
    }
  } catch (Exception e) {
    e.printStackTrace();
  }
  %>
</body>
</html>