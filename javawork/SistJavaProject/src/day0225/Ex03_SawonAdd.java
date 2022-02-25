package day0225;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex03_SawonAdd {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);

  public void insertSawon() {
    System.out.println("사원 추가 하기");
    System.out.println("사원명?");
    String name = stdIn.nextLine();
    System.out.println("부서명?");
    String buseo = stdIn.nextLine();
    System.out.println("성별(남자/여자)");
    String gender = stdIn.nextLine();
    System.out.println("원급여?");
    int pay = Integer.parseInt(stdIn.nextLine());

    String sql = "insert into sawon values(seq_sawon.nextval, '" + name + "', '" + gender + "', '"
        + buseo + "', " + pay + ")";
    // System.out.println(sql);

    Connection conn = db.getOracle();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      stmt.execute(sql); // sql문 실행(insert, delete, update - execute() or executeUpdate() 둘중 하나 사용

      System.out.println("db에 추가되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public void selectSawon() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;

    String sql = "select * from sawon"; // num, name, gender, buseo, pay

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      System.out.println("사원번호\t사원명\t성별\t부서명\t월급여");
      System.out.println("------------------------------------");

      while (rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String gedner = rs.getString("gender");
        String buseo = rs.getString("buseo");
        int pay = rs.getInt("pay");

        System.out.println(num + "\t" + name + "\t" + gedner + "\t" + buseo + "\t" + pay);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
  }

  public void deleteSawon() {
    System.out.println("삭제할 사원 명을 입력해주세요");
    String name = stdIn.nextLine();
    String sql = "deleete from sawon where name = '" + name + "'";

    Connection conn = db.getOracle();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();

      // 이름이 없을 경우 0반환
      int n = stmt.executeUpdate(sql);

      if (n == 0) {
        System.out.println(name + "님은 사원 명단에 없습니다.");
      } else {
        System.out.println(name + "님을 명단에서 삭제했습니다.");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  public void updateSawon() {
    System.out.println("수정할 사원번호는?");
    int num = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 이릅 입력");
    String name = stdIn.nextLine();
    System.out.println("수정할 부서 입력");
    String buseo = stdIn.nextLine();
    System.out.println("수정할 급여는?");
    int pay = Integer.parseInt(stdIn.nextLine());

    String sql = "update sawon set name = '" + name + "', buseo='" + buseo + "', pay=" + pay
        + " where num = " + num;

    Connection conn = db.getOracle();
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      int a = stmt.executeUpdate(sql);
      if (a == 0) {
        System.out.println("수정할 데이터가 존재하지 않음");
      } else {
        System.out.println("수정되었습니다.");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }

  }

  public void findByName() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;
    System.out.println("검색할 사원은 누구입니까?(일부도 가능)");
    String tmp = stdIn.nextLine();
    String sql = "select * from sawon where name like '%" + tmp + "%'";

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      System.out.println("사원번호\t사원명\t성별\t부서명\t월급여");
      System.out.println("------------------------------------");

      while (rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String gedner = rs.getString("gender");
        String buseo = rs.getString("buseo");
        int pay = rs.getInt("pay");

        System.out.println(num + "\t" + name + "\t" + gedner + "\t" + buseo + "\t" + pay);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
  }

  public static void main(String[] args) {
    Ex03_SawonAdd ex = new Ex03_SawonAdd();
    Scanner stdIn = new Scanner(System.in);

    int n = 0;
    while (true) {
      System.out.println("oracle db 연습문제");
      System.out.println("1.Insert\t2.select\t3.update\t4.delete\t5.사원검색\t9.exit");
      n = Integer.parseInt(stdIn.nextLine());

      if (n == 1) {
        ex.insertSawon();
      } else if (n == 2) {
        ex.selectSawon();
      } else if (n == 3) {
        ex.updateSawon();
      } else if (n == 4) {
        ex.deleteSawon();
      } else if (n == 5) {
        ex.findByName();
      } else {
        break;
      }
    }
  }
}
