package month03.day02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMyStudent {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);

  // create table myStudent(
  // num number(5) primary key,
  // name varchar2(20),
  // hp varchar2(20),
  // age number(10),
  // sdate date);

  // insert
  public void insertMyStudent() {
    String name, hp, sql;
    int age;

    System.out.println("your name?");
    name = stdIn.nextLine();
    System.out.println("your hp?");
    hp = stdIn.nextLine();
    System.out.println("your age?");
    age = Integer.parseInt(stdIn.nextLine());

    sql = "insert into mystudent values(seql.nextval, '" + name + "', '" + hp + "', " + age
        + ", sysdate)";

    Connection conn = db.getOracle();
    Statement stmt = null;

    try {
      stmt = conn.createStatement();
      int n = stmt.executeUpdate(sql);

      System.out.println(n + "행 삽입되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(stmt, conn);
    }
  }

  // write
  public void writeMyStudent() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;

    String sql = "select * from mystudent";

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      System.out.println("시퀀스\t이름\t핸드폰\t나이\t가입일자");
      System.out.println("----------------------------------");

      while (rs.next()) {
        int num = rs.getInt("num");
        String name = rs.getString("name");
        String hp = rs.getString("hp");
        int age = rs.getInt("age");
        Date sdate = rs.getDate("sdate");

        System.out.println(num + "\t" + name + "\t" + hp + "\t" + age + "\t" + sdate);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
  }


  // delete
  public void deleteMyStudent() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("삭제할 번호를 입력해주세요");
    int deleteNum = Integer.parseInt(stdIn.nextLine());

    String sql = "delete from mystudent where num = " + deleteNum;
    
    Connection conn = db.getOracle();
    Statement stmt = null;
    
    try {
      stmt = conn.createStatement();
      int n = stmt.executeUpdate(sql);
      
      System.out.println(n + "행 삭제되었습니다.");
      
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      db.dbClose(stmt, conn);
    }
  }


  // update
  public void updateMyStudent() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("수정할 번호");
    int num = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 이름");
    String name = stdIn.nextLine();
    System.out.println("수정할 핸드폰 번호");
    String hp = stdIn.nextLine();
    System.out.println("수정할 나이");
    int age = Integer.parseInt(stdIn.nextLine());
    
    String sql = "update mystudent set name = ?, hp = ?, age = ? where num = ?";
    
    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, name);
      ps.setString(2, hp);
      ps.setInt(3, age);
      ps.setInt(4, num);
      
      int n = ps.executeUpdate();
      System.out.println(n + "행이 업데이트 되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }


  public static void main(String[] args) {
    JdbcMyStudent jdbcMyStudent = new JdbcMyStudent();
    Scanner stdIn = new Scanner(System.in);
    int n;
    while (true) {
      System.out.println("선택 메뉴");
      System.out.println("1.추가  2.삭제  3.수정  4.전체출력  9.종료");
      System.out.print("선택 번호: ");
      n = Integer.parseInt(stdIn.nextLine());

      if (n == 9) {
        System.out.println("프로그램 종료됨");
        break;
      }

      switch (n) {
        case 1:
          jdbcMyStudent.insertMyStudent();
          break;
        case 2:
          jdbcMyStudent.deleteMyStudent();
          break;
        case 3:
          jdbcMyStudent.updateMyStudent();
          break;
        case 4:
          jdbcMyStudent.writeMyStudent();
          break;
      }
      System.out.println();
    }
  }
}
