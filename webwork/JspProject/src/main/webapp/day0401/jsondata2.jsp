<%@page import="java.sql.SQLException"%>
<%@page import="java.text.SimpleDateFormat"%>
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

String sql = "select * from info order by num";
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

String s = "[";

try {
  ps = conn.prepareStatement(sql);
  rs = ps.executeQuery();

  while (rs.next()) {
    String num = rs.getString("num");
    String name = rs.getString("name");
    String hp = rs.getString("hp");
    String age = rs.getString("age");
    String photo = rs.getString("photo");

    s += "{";
    s += "\"num\": \"" + num + "\", ";
    s += "\"name\": \"" + name + "\", ";
    s += "\"hp\": \"" + hp + "\", ";
    s += "\"age\": \"" + age + "\", ";
    s += "\"photo\": \"" + photo + "\"";
    s += "},";
  }
  
  s = s.substring(0, s.length() - 1);
} catch (SQLException e) {

} finally {
  db.dbClose(rs, ps, conn);
}
s += "]";
%>
<%= s %>
