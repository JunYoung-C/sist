<?xml version="1.0" encoding="UTF-8"?>
<%@page import="memo.MemoDto"%>
<%@page import="memo.MemoDao"%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<data>
<% 
MemoDao dao = new MemoDao();

String num = request.getParameter("num");

MemoDto dto = dao.getData(num);
%>
<num><%= dto.getNum() %></num>
<writer><%= dto.getWriter() %></writer>
<content><%= dto.getContent() %></content>
<avatar><%= dto.getAvatar() %></avatar>
</data>