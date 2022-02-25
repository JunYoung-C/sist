package day0225;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

public class Ex01_ReviewJdbc {
  static final String ORACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:XE"; 
  
  public void writeShop() {
    String sql = "select c.idx, s.num, s.sangpum, s.color, c.cnt, c.guipday from shop s, cart1 c where s.num = c.num";
    
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      conn = DriverManager.getConnection(ORACLE_LOCAL, "angel", "a1234");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      System.out.println("주문번호\t상품번호\t상품명\t색상\t구입개수\t구입일자");
      while (rs.next()) {
        int idx = rs.getInt("idx");
        int num = rs.getInt("num");
        String sangpum = rs.getString("sangpum");
        String color = rs.getString("color");
        int cnt = rs.getInt("cnt");
        Date guipday = rs.getDate("guipday");
        System.out.println(idx + "\t" + num+ "\t" + sangpum+ "\t" + color+ "\t" + cnt+ "\t" + guipday);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
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
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    
  }
  public static void main(String[] args) {
    Ex01_ReviewJdbc ex = new Ex01_ReviewJdbc();
    ex.writeShop();
  }
}
