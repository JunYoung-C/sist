<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Hi+Melody&family=Titillium+Web:wght@200&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	
	//이메일 선택 이벤트
	$("#selemail").change(function(){
		
			if($(this).val()=='_')
			{
			  $("#email2").val(''); //지정된메일 지우기
			}else
			{
				$("#email2").val($(this).val());
			}
	});
	
	
	//아이디입력 이벤트...idserch.jsp
	$("#btnidcheck").click(function(){
		
		window.open("member/idsearch.jsp","","width=600px,height=200px,left=500px,top=100px");
	});
	
});


function check(f)
{
	//비번같게 하기
	if(f.pass.value!=f.pass2.value)
		{
		  alert("비밀번호가 서로 다릅니다");
		  f.pass.value="";
		  f.pass2.value="";
		  return false; 
		}
	
	
}

</script>
<title>Insert title here</title>
</head>
<body>
<form action="member/memberadd.jsp" method="post" class="form-inline" onsubmit="return check(this)" name="mfrm">
  <table class="table table-bordered" style="width: 500px; margin: 0 auto;">
    <caption><b>회원가입</b></caption>
      <tr>
        <th width="100" bgcolor="#aaa">아이디</th>
          <td>
            <input type="text" name="id" class="form-control" required="required" readonly="readonly" style="width: 120px;">
            <button type="button" class="btn btn-danger btn-sm" id="btnidcheck">아이디입력</button>
          </td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="#aaa">비밀번호</th>
          <td>
            <input type="password" name="pass" class="form-control" required="required" style="width: 120px;"
            placeholder="비밀번호">
            <input type="password" name="pass2" class="form-control" required="required" style="width: 120px;"
            placeholder="비밀번호 확인">
          </td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="#aaa">이름</th>
          <td>
            <input type="text" name="name" class="form-control" required="required" style="width: 120px;"
            placeholder="이름입력">
            
          </td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="#aaa">핸드폰</th>
          <td>
            <input type="text" name="hp" class="form-control" required="required" style="width: 200px;"
            placeholder="010-***-****">
            
          </td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="#aaa">주소</th>
          <td>
            <input type="text" name="addr" class="form-control" required="required" style="width: 400px;">
            
          </td>
      </tr>
      
      <tr>
        <th width="100" bgcolor="#aaa">이메일</th>
          <td>
            <input type="text" name="email1" class="form-control" required="required" style="width: 80px;">
            <b>@</b>
            <input type="text" name="email2" id="email2" class="form-control" required="required" style="width: 150px;">
            <select id="selemail">
              <option value="_">직접입력</option>
              <option value="naver.com">네이버</option>
              <option value="gmail.com">구글</option>
              <option value="daum.net">다음</option>
              <option value="nate.com">네이트</option>
            </select>
          </td>
      </tr>
      
      <tr>
        <td align="center" colspan="2" bgcolor="#aaa">
          <button type="submit" class="btn btn-default">저장하기</button>
          <button type="reset" class="btn btn-default">다시하기</button>
        </td>
      </tr>
  </table>
</form>
</body>
</html>