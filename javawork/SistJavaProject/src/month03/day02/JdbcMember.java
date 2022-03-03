package month03.day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcMember {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);
  String selectByNameSql = "select sno, name, buseo, position, gender, to_char(pay, 'L999,999,999') "
      + "payStr, to_char(bonus, 'L999,999,999') bonusStr from mymember where name like ?";
  String selectAllSql = "select sno, name, buseo, position, gender, to_char(pay, 'L999,999,999') "
      + "payStr, to_char(bonus, 'L999,999,999') bonusStr from mymember";
  String deleteSql = "delete from mymember where sno = ?";
  String updateSql = "update mymember set buseo = ?, position = ?, pay = ?, bonus = ? where sno = ?";
  String insertSql = "insert into mymember values(seq_mem.nextval, ?, ?, ?, ?, ?, ?)";

  // sno, name, buseo, position, gender, pay, bonus

  // selectByName
  private void selectByNameMember() {
    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    ResultSet rs = null;
    System.out.println("검색할 사원이 이름을 입력하세요(일부도 가능)");
    String findName = stdIn.nextLine();
    
    try {
      ps = conn.prepareStatement(selectByNameSql);
      ps.setString(1, "%" + findName + "%");
      rs = ps.executeQuery();

      System.out.println("사원 번호\t사원명\t부서\t직급\t성별\t월급여\t보너스");
      System.out.println("=======================================================");
      String name, buseo, position, gender, payStr, bonusStr;
      int sno;
      while (rs.next()) {
        sno = rs.getInt("sno");
        name = rs.getString("name");
        buseo = rs.getString("buseo");
        position = rs.getString("position");
        gender = rs.getString("gender");
        payStr = rs.getString("payStr").trim();
        bonusStr = rs.getString("bonusStr").trim();

        System.out.println(sno + "\t" + name + "\t" + buseo + "\t" + position + "\t" + gender + "\t"
            + payStr + "\t" + bonusStr);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
  }

  // selectAll
  private void selectAllMember() {
    Connection conn = db.getOracle();
    Statement stmt = null;
    ResultSet rs = null;

    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(selectAllSql);

      System.out.println("사원 번호\t사원명\t부서\t직급\t성별\t월급여\t보너스");
      System.out.println("=======================================================");
      String name, buseo, position, gender, payStr, bonusStr;
      int sno;
      while (rs.next()) {
        sno = rs.getInt("sno");
        name = rs.getString("name");
        buseo = rs.getString("buseo");
        position = rs.getString("position");
        gender = rs.getString("gender");
        payStr = rs.getString("payStr").trim();
        bonusStr = rs.getString("bonusStr").trim();

        System.out.println(sno + "\t" + name + "\t" + buseo + "\t" + position + "\t" + gender + "\t"
            + payStr + "\t" + bonusStr);
      }

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, stmt, conn);
    }
  }

  // insert
  private void insertMember() {
    System.out.println("새로운 사원 정보 입력");
    System.out.print("이름 : ");
    String name = stdIn.nextLine();
    System.out.print("부서 : ");
    String buseo = stdIn.nextLine();
    System.out.print("직급 : ");
    String position = stdIn.nextLine();
    System.out.print("성별 : ");
    String gender = stdIn.nextLine();
    System.out.print("월급여 : ");
    int pay = Integer.parseInt(stdIn.nextLine());
    System.out.print("보너스 : ");
    int bonus = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(insertSql);
      ps.setString(1, name);
      ps.setString(2, buseo);
      ps.setString(3, position);
      ps.setString(4, gender);
      ps.setInt(5, pay);
      ps.setInt(6, bonus);

      int n = ps.executeUpdate();

      System.out.println(n + "행 삽입되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  // delete
  private void deleteMember() {
    System.out.println("삭제할 사원 번호를 입력하세요");
    int deleteNum = Integer.parseInt(stdIn.nextLine());
    
    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(deleteSql);
      ps.setInt(1, deleteNum);

      int n = ps.executeUpdate();

      System.out.println(n + "행 삭제되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  // update
  private void updateMember() {
    System.out.println("수정할 사원 정보 입력");
    System.out.print("사원 번호 : ");
    int sno = Integer.parseInt(stdIn.nextLine());
    System.out.print("부서 : ");
    String buseo = stdIn.nextLine();
    System.out.print("직급 : ");
    String position = stdIn.nextLine();
    System.out.print("월급여 : ");
    int pay = Integer.parseInt(stdIn.nextLine());
    System.out.print("보너스 : ");
    int bonus = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    try {
      ps = conn.prepareStatement(updateSql);
      ps.setString(1, buseo);
      ps.setString(2, position);
      ps.setInt(3, pay);
      ps.setInt(4, bonus);
      ps.setInt(5, sno);

      int n = ps.executeUpdate();

      System.out.println(n + "행 수정되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  private void process() {
    int select;
 
    while (true) {
      System.out.println("**1.사원 정보 입력  2.전체 사원 출력  3.사원 삭제  4.사원 수정  5 이름 검색  9.시스템 종료**");
      select = Integer.parseInt(stdIn.nextLine());

      switch (select) {
        case 1:
          // insert
          insertMember();
          break;
        case 2:
          // selectAll
          selectAllMember();
          break;
        case 3:
          // delete
          deleteMember();
          break;
        case 4:
          // update
          updateMember();
          break;
        case 5:
          // selectByName
          selectByNameMember();
          break;
        default:
          System.out.println("프로그램 종료");
          break;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    JdbcMember q = new JdbcMember();
    q.process();
  }
}
