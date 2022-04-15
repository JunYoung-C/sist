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

<!--include: 이동했다 돌아옴..예를 들면 방문횟수 같은것 만들때 사용 ..
forward: 이동했다 돌아오지 않는다, 다른파일로 이동
redirect: forward는 url주소가 안바뀌고, redirect는 주소가 바끤다
forward는 request,response가 그대로 전달되고 redirect는 전달안됨-->
</head>
<body>
<h2>다른폴더의 파일 include하기</h2>
<h4>3번 구구단 예제</h4>
  <jsp:include page="gugu_03.jsp"/>
  <hr>
<h4>5번 중첩배열 이미지</h4>
	<jsp:include page="imgArrayQuiz_05.jsp"/>

</body>
</html>