package day0225;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex04_JdbcHello {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);

  // numm, name, addr, sdate
  void InsertHello() {
    System.out.println("데이터 추가하기");
    System.out.println("이름은?");
    String name = stdIn.nextLine();
    System.out.println("주소는?");
    String addr = stdIn.nextLine();

    String sql =
        "insert into hello values(seq_hello.nextval, '" + name + "', '" + addr + "' , sysdate)";

    Connection conn = db.getOracle();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      stmt.execute(sql);

      System.out.println("db에 추가되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  void selectHello() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;

    String sql = "select * from hello";

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      
      System.out.println("번호\t이름\t주소\t생성날짜");
      System.out.println("----------------------------------");

      while (rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String addr = rs.getString("addr");
        Date sdate = rs.getDate("sdate");

        System.out.println(num + "\t" + name + "\t" + addr + "\t" + sdate);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
  }

  void deleteHello() {
    System.out.println("삭제할 번호를 입력해주세요");
    int num = Integer.parseInt(stdIn.nextLine());
    String sql = "delete from hello where num = '" + num + "'";

    Connection conn = db.getOracle();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();

      // 이름이 없을 경우 0반환
      int n = stmt.executeUpdate(sql);

      if (n == 0) {
        System.out.println("해당 번호는 존재하지 않습니다.");
      } else {
        System.out.println("삭제되었습니다.");
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  void updateHello() {
    System.out.println("수정할 번호 입력");
    int num = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 이릅 입력");
    String name = stdIn.nextLine();
    System.out.println("수정할 주소 입력");
    String addr = stdIn.nextLine();

    String sql = "update hello set name = '" + name + "', addr = '" + addr + "' where num = " + num;

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

  void process() {
    Scanner stdIn = new Scanner(System.in);

    int n = 0;
    while (true) {
      System.out.println("1.insert\t2.select\t3.update\t4.delete\t9.exit");
      n = Integer.parseInt(stdIn.nextLine());

      if (n == 1) {
        InsertHello();
      } else if (n == 2) {
        selectHello();
      } else if (n == 3) {
        updateHello();
      } else if (n == 4) {
        deleteHello();
      } else {
        System.out.println("종료되었습니다.");
        break;
      }
    }
  }

  public static void main(String[] args) {
    Ex04_JdbcHello ex = new Ex04_JdbcHello();
    ex.process();
  }
}
