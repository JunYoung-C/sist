<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name=request.getParameter("name");
String sang=request.getParameter("sang");
String price=request.getParameter("price");
String color=request.getParameter("color");

JSONObject ob=new JSONObject();
ob.put("name", name);
ob.put("sang",sang);
ob.put("price", price);
ob.put("color", color);
%>
<%=ob.toString()%>