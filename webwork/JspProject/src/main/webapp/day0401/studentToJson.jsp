<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="mysql.db.DbConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%
DbConnect db = new DbConnect();
Connection conn = db.getConnection();
PreparedStatement ps = null;
ResultSet rs = null;

String sql = "select * from student order by num";

String s = "[";
try {
  ps = conn.prepareStatement(sql);
  rs = ps.executeQuery();

  while (rs.next()) {
    String num = rs.getString("num");
    String name = rs.getString("name");
    String photo = rs.getString("photo");
    String java = rs.getString("java");
    String spring = rs.getString("spring");

    s += "{";
    s += "\"num\": \"" + num + "\", ";
    s += "\"name\": \"" + name + "\", ";
    s += "\"photo\": \"" + photo + "\", ";
    s += "\"java\": \"" + java + "\", ";
    s += "\"spring\": \"" + spring + "\"";
    s += "},";
  }

  s = s.substring(0, s.length() - 1);
} catch (SQLException e) {
  System.out.println(e.getMessage());
} finally {
  db.dbClose(rs, ps, conn);
}

s += "]";
%>
<%= s %>
