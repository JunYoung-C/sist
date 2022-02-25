package day0224;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {
  static final String ORACLE_LOCAL = "jdbc:oracle:thin:@localhost:1521:XE"; // localhost는 ip주소로 입력
                                                                            // 가능

  public void connectSawon() {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null; // select는 반드시 ResultSet 객체를 생성해야함.

    String sql = "select * from sawon order by num";

    try {
      conn = DriverManager.getConnection(ORACLE_LOCAL, "angel", "a1234");
      System.out.println("오라클 서버 연결 성공");

      stmt = conn.createStatement();
      System.out.println("createStatement 성공");
      rs = stmt.executeQuery(sql);
      System.out.println("executeQuery 성공");

      System.out.println("사원리스트");
      System.out.println("사원번호\t사원명\t성별\t부서명\t급여");
      System.out.println("---------------------------------");
      // 여러줄을 읽어와야 하므로 while문으로 가져온다
      // rs.next();
      while (rs.next()) {
        // db로부터 데이터 가져오기
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String gender = rs.getString("gender");
        String buseo = rs.getString("buseo");
        int pay = rs.getInt("pay");
        System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      System.out.println("오라클 생성 실패");
    } finally {
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

  public void connectFood() {
    String sql =
        "select f.fno 주문번호, j.name, f.food, f.price, j.addr from food f, jumun j where f.fno = j.fno";

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
      conn = DriverManager.getConnection(ORACLE_LOCAL, "angel", "a1234");
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      System.out.println("주문번호\t주문자\t음식명\t가격\t배달지주소");
      while (rs.next()) {
        int fno = rs.getInt("주문번호");
        String name = rs.getString("name");
        String food = rs.getString("food");
        int price = rs.getInt("price");
        String addr = rs.getString("addr");
        System.out.println(fno + "\t" + name + "\t" + food + "\t" + price + "\t" + addr);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
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
    JdbcTest jdbcTest = new JdbcTest();
    // jdbcTest.connectSawon();
    jdbcTest.connectFood();

  }
}
