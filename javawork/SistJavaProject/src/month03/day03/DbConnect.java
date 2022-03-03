package month03.day03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {
  static final String ORACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:XE";

  public Connection getOracle() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(ORACLE_LOCAL, "angel", "a1234");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("오라클 연결 실패");
    }

    return conn;
  }

  // close - select, 완성형 sql(statement)
  public void dbClose(ResultSet rs, Statement stmt, Connection conn) {
    try {
      if (rs != null)
        rs.close();
      if (stmt != null)
        stmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  //close - 완성형 sql(statement)
  public void dbClose(Statement stmt, Connection conn) {
    try {
      if (stmt != null)
        stmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
    try {
      if (rs != null)
        rs.close();
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void dbClose(PreparedStatement pstmt, Connection conn) {
    try {
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
