package month03.day03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SungjukJdbc {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);

  private void insertSungjuk() {
    System.out.println("학생명?");
    String name = stdIn.nextLine();
    System.out.println("JAVA 점수는?");
    int java = Integer.parseInt(stdIn.nextLine());
    System.out.println("ORACLE 점수는?");
    int oracle = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    String sql = "insert into sungjuk (num, name, java, oracle) values(seq_test.nextval, ?, ?, ?)";

    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setInt(2, java);
      ps.setInt(3, oracle);

      ps.execute();
      System.out.println("추가됨!");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public void deleteSungjuk() {
    System.out.println("삭제할 번호를 입력하세요");
    int num = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    String sql = "delete from sungjuk where num = ?";

    try {
      ps = conn.prepareStatement(sql);

      ps.setInt(1, num);
      int n = ps.executeUpdate();
      if (n == 0) {
        System.out.println(num + "번 학생은 존재하지 않습니다.");
      } else {
        System.out.println(num + "번 학생 정보 삭제함");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  private void updateSungjuk() {
    System.out.println("수정할 번호 입력");
    int num = Integer.parseInt(stdIn.nextLine());

    System.out.println("수정할 JAVA 점수는?");
    int java = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 ORACLE 점수는?");
    int oracle = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    String sql = "update sungjuk set java = ?, oracle = ? where num = ?";

    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, java);
      ps.setInt(2, oracle);
      ps.setInt(3, num);

      int n = ps.executeUpdate();

      if (n == 1) {
        System.out.println("수정됨");
      } else {
        System.out.println("학생이 존재하지 않습니다.");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  private void calcTotAvg() {
    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    
    String sql = "update sungjuk set total = java+oracle, average = (java+oracle)/2";
    try {
      ps = conn.prepareStatement(sql);
      ps.execute();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }
  private void writeAll() {
    
    this.calcTotAvg();
    
    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from sungjuk order by num";
    System.out.println("학생 성적 출력");
    System.out.println();
    System.out.println("번호\t이름\t자바\t오라클\t총점\t평균");
    System.out.println("----------------------------");

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      while (rs.next()) {
        System.out.println(
            rs.getInt("num") + "\t" + rs.getString("name") + "\t" + rs.getInt("java") + "\t"
                + rs.getInt("oracle") + "\t" + rs.getInt("total") + "\t" + rs.getDouble("average"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
  }

  private void process() {
    while (true) {
      System.out.println("1. 힉생 성적 추가  2. 학생 정보 삭제  3. 학생 정보 수정  4. 학생 정보 출력  9. 종료");
      int num = Integer.parseInt(stdIn.nextLine());
      switch (num) {
        case 1:
          this.insertSungjuk();
          break;
        case 2:
          this.deleteSungjuk();
          break;
        case 3:
          this.updateSungjuk();
          break;
        case 4:
          this.writeAll();
          break;
        default:
          System.out.println("성적 프로그램 종료");
          break;
      }
    }
  }

  public static void main(String[] args) {
    SungjukJdbc ex = new SungjukJdbc();
    ex.process();
  }
}
