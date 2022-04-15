<?xml version="1.0" encoding="UTF-8"?>
<%@page import="memo.MemoDto"%>
<%@page import="memo.MemoDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<%
//dao선언
MemoDao dao=new MemoDao();
//num읽기
String num=request.getParameter("num");
//getData호출한 dto받기
MemoDto dto=dao.getData(num);
%>
<num><%=dto.getNum() %></num>
<writer><%=dto.getWriter() %></writer>
<content><%=dto.getContent() %></content>
<avatar><%=dto.getAvatar() %></avatar>
</data>