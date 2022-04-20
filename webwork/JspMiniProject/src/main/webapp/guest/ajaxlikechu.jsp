<%@page import="org.json.simple.JSONObject"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//num읽기
String num=request.getParameter("num");
//dao
GuestDao dao=new GuestDao();
//num 에 해당하는 chu증가
dao.updateChu(num);
//증가된 chu값 json으로 반환
int chu=dao.getData(num).getChu();
JSONObject ob=new JSONObject();
ob.put("chu", chu);
%>
<%=ob.toString()%>