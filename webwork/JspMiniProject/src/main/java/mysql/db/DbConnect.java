package mysql.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
  static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
  static final String MYSQL_URL = "jdbc:mysql://localhost:3306/sist";

  public DbConnect() {
    try {
      Class.forName(MYSQL_DRIVER);
    } catch (ClassNotFoundException e) {
      System.out.println("MySql 드라이버 싪패: " + e.getMessage());
    }
  }
  
  // 계정 연결
  public Connection getConnection() {
    Connection conn = null;

    try {
      conn = DriverManager.getConnection(MYSQL_URL, "root", "1234");
    } catch (SQLException e) {
      System.out.println("MySql 연결 실패: " + e.getMessage());
      e.printStackTrace();
    }

    return conn;
  }

  public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
    try {
      if (rs != null) {
        rs.close();
      }

      if (stmt != null) {
        stmt.close();
      }

      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void dbClose(ResultSet rs, PreparedStatement ps, Connection conn) {
    try {
      if (rs != null) {
        rs.close();
      }

      if (ps != null) {
        ps.close();
      }

      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void dbClose(Statement stmt, Connection conn) {
    try {

      if (stmt != null) {
        stmt.close();
      }

      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void dbClose(PreparedStatement ps, Connection conn) {
    try {

      if (ps != null) {
        ps.close();
      }

      if (conn != null) {
        conn.close();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


}
