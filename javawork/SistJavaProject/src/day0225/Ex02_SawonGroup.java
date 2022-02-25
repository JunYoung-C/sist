package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02_SawonGroup {
  DbConnect db = new DbConnect();
  
  public void writeSawonGroup() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;
    
    String sql = "select buseo, count(buseo) count, round(avg(pay), 0) avgpay, max(pay) maxpay, "
        + "min(pay) minpay from sawon group by buseo";
    
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      System.out.println("부서명\t인원수\t평균급여\t최고급여\t최저급여");
      System.out.println("------------------------------------");
      
      while (rs.next()) {
        String buseo = rs.getString(1);
        int count = rs.getInt(2);
        int avgpay = rs.getInt(3);
        int maxpay = rs.getInt(4);
        int minpay = rs.getInt(5);
        
        System.out.println(buseo + "\t" + count+ "\t" +avgpay+ "\t" +maxpay+ "\t" +minpay);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      db.dbClose(rs, stmt, conn);
    }
  }
  
  public static void main(String[] args) {
    Ex02_SawonGroup ex = new Ex02_SawonGroup();
    ex.writeSawonGroup();
  }
}
