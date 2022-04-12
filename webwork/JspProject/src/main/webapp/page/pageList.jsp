<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link
      href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap"
      rel="stylesheet"
    />
    <!-- Latest compiled and minified CSS -->
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
SimpleDao = new SimplaDao();
// List<SimpleDto> list = db.getAllDatas();

// 페이징 처리에 필요한 변수
int totalCount;
int totalPage;
int startPage;
int endPage;
int start;
int perPage = 5;
int perBlock = 5;
int currentPage;

int no;

// 총 개수
totalCount = db.getTotalcount();

//현재 페이지 번호 읽기 (단 null인 경우는 1페이지로 설정)
if (request.getParameter("currentPage") == null) {
  currentPage = 1;
} else {
  currentPage = Integer.parseInt(request.getParameter("currenPage"));
}

//총 페이지 개수 구하기
totalPage = totalCount / perPage + (totalCount % perPage == 0 ? 0 : 1);

// 각 블럭의 시작페이지
startPage = (currentPage -1) / perBlock * perBlock + 1;
endPage= startPage + perBlock - 1;

if (endPage > totalPage) {
  endPage = totalPage;
}

// 각페이지에서 불러올 시작 번호
start = (currentPage - 1) * perPage;

//각 페이지에서 필요한 게시글 가져오기
List<SimpleDto> list = db.getList(start, perPage);

// 각 글앞에 붙일 시작번호 구하기
no = totalCount - (currentPage - 1) * perPage;
%>
</body>
</html>