<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="memo.MemoDto"%>
<%@page import="java.util.List"%>
<%@page import="memo.MemoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
MemoDao dao = new MemoDao();

List<MemoDto> list = dao.getAllDatas();

JSONArray arr = new JSONArray();

SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm");

for (MemoDto dto : list) {
  JSONObject ob =new JSONObject();
  
  ob.put("num", dto.getNum());
  ob.put("writer", dto.getWriter());
  ob.put("content", dto.getContent());
  ob.put("avatar", dto.getAvatar());
  ob.put("writeday", sdf.format(dto.getWriteday()));
  
  arr.add(ob);
}
%>

<%= arr.toString() %>