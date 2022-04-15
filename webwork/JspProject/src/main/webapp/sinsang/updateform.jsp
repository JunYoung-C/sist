<%@page import="java.util.StringTokenizer"%>
<%@page import="sinsang.SinsangDto"%>
<%@page import="sinsang.SinsangDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Gamja+Flower&family=Hi+Melody&family=Nanum+Brush+Script&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
function goFocus(hp){
	if(hp.value.length==4)
		frm.hp3.focus();
}

</script>
</head>
<%
String num=request.getParameter("num");
SinsangDao dao=new SinsangDao();
SinsangDto dto=dao.getData(num);
%>
<body>
<form action="updateaction.jsp" method="post" name="frm">
  <table class="table table-bordered" style="width: 350px;">
    <caption><b>개인신상명세(수정)</b></caption>
      <tr>
        <th width="100">이름</th>
          <td>
            <input type="text" name="name" size="8"
            value="<%=dto.getName()%>">
          </td>
      </tr>
      
      <tr>
        <th>혈액형</th>
          <td>
            <select size="1" name="blood">
              <%
              String []str={"A","B","O","AB"};
              for(int i=0;i<str.length;i++)
              {
            	  if(dto.getBlood().equalsIgnoreCase(str[i]))
            	  {%>
            		 <option value="<%=str[i]%>" selected="selected"><%=str[i] %>형</option> 
            		  
            	  <%}else
            	  {%>
            		  <option value="<%=str[i]%>"><%=str[i] %>형</option>
            	  <%}
              }
              
              %>
            </select>
          </td>
      </tr>
      
      <tr>
      <%
      //-(하이픈)을 구분자로 분리
      StringTokenizer st=new StringTokenizer(dto.getHp(),"-");
      
      String hp1=st.nextToken();
      String hp2=st.nextToken();
      String hp3=st.nextToken();
      %>
      
        <th>핸드폰</th>
          <td>
            <select name="hp1">
              <%
              String [] strhp={"010","017","019","02"};
              for(int i=0;i<strhp.length;i++)
              {
            	  if(hp1.equals(strhp[i]))
            	  {%>
            		 <option value="<%=strhp[i]%>" selected="selected"><%=strhp[i]%></option> 
            	  <%}else
            	  {%>
            		  <option value="<%=strhp[i]%>"><%=strhp[i]%></option>
            	  <%}
              }
              
              %>
            </select>
            <b>-</b>
            <input type="text" name="hp2" size="3"
             onkeyup="goFocus(this)" value="<%=hp2%>">
            <b>-</b>
            <input type="text" name="hp3" size="3" value="<%=hp3%>">
          </td>
      </tr>
      
      <tr>
        <th>생년월일</th>
         <td>
           <input type="date" name="birth" value="<%=dto.getBirth()%>">
         </td>
      </tr>
      
      <tr>
        <td colspan="2" align="center">
        <input type="hidden" name="num" value="<%=dto.getNum()%>">
          <input type="submit" value="db저장">
          <input type="button" value="목록" 
          onclick="location.href='sslist.jsp'">
        </td>
      </tr>
  </table>
</form>
</body>
</html>