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
<style type="text/css">
table {
  border-collapse: collapse;
  border: 2px solid gray;
  width: 250px;
}

tr, th, td {
  border: 1px solid green;
  font-size: 11pt;
}
</style>

</head>
<body>
  <form action="ex12.jsp" method="post">
    <table>
      <tr>
        <th width="70">근무 희망 1</th>
        <td><select size="1" name="city">
            <option value="서울">서울</option>
            <option value="경기">경기</option>
            <option value="인천">인천</option>
            <option value="광주">광주</option>
            <option value="대전">대전</option>
            <option value="대구">대구</option>
            <option value="부산">부산</option>
        </select></td>
      </tr>

      <tr>
        <th width="70">근무 희망 2</th>
        <td><select size="7" name="city2" multiple="multiple"
          style="width: 100px;">
            <option value="서울">서울</option>
            <option value="경기">경기</option>
            <option value="인천">인천</option>
            <option value="광주">광주</option>
            <option value="대전">대전</option>
            <option value="대구">대구</option>
            <option value="부산">부산</option>
        </select></td>
      </tr>

      <tr>
      <td colspan="2" align="center">
        <input type="submit" value="전송">
        <input type="reset" value="초기화">
      </td>
      </tr>
    </table>
  </form>
</body>
</html>