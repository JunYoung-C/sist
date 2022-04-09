<%@page import="java.util.UUID"%>
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
  String folder = "/save";
  ServletContext context = getServletContext();
  String realFolder = context.getRealPath(folder);

  System.out.println("folder: " + realFolder); // 해당 경로에 폴더 필수

  int filesize = 1024 * 1024 * 5; // 5MB

  MultipartRequest multi = null;

  try {
    multi =
    new MultipartRequest(request, realFolder, filesize, "utf-8", new DefaultFileRenamePolicy());

    String name = multi.getParameter("name");
    String title = multi.getParameter("title");
    String uploadFilename = multi.getFilesystemName("uploadFile");
    String originalFilename = multi.getOriginalFileName("uploadFile");
  %>

  <table class="table table-bordered" style="width: 300px;">
    <tr>
      <th width="100">이름</th>
      <td><%= name %></td>
    </tr>
    
    <tr>
      <th width="100">제목</th>
      <td><%= title %></td>
    </tr>
    
    <tr>
      <th width="100">업로드된 파일명</th>
      <td><img src="../save/<%= uploadFilename %>"></td>
    </tr>
    
    <tr>
      <td colspan="2" align="center">
        <input type="button" value="다시 업로드 하기" onclick="location.href='uploadform.jsp'">
      </td>
    </tr>
  </table>

  <%
  } catch (Exception e) {
    e.printStackTrace();
  }
  %>
</body>
</html>