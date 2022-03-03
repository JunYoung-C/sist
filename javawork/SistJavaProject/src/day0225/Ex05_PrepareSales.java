package day0225;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ex05_PrepareSales {
  DbConnect db = new DbConnect();
  Scanner stdIn = new Scanner(System.in);

  void insertSangpum() {
    Connection conn = db.getOracle();
    PreparedStatement pstmt = null;

    System.out.println("1.음료\t2.과일 중 택 1");
    int type = Integer.parseInt(stdIn.nextLine());
    System.out.println("상품명?");
    String sang = stdIn.nextLine();
    System.out.println("수량?");
    int su = Integer.parseInt(stdIn.nextLine());
    System.out.println("단가?");
    int dan = Integer.parseInt(stdIn.nextLine());

    // prepareStatement 객체는 미완의 sql 문을 적상할 수 있다. 변수를 ?처리
    String sql = "insert into sales values(seql.nextval, ?, ?, ?, ?, sysdate)";
    try {
      pstmt = conn.prepareStatement(sql);
      // 순서대로 변수를 바인딩 시켜준다.
      pstmt.setString(1, type == 1 ? "음료" : "과일");
      pstmt.setString(2, sang);
      pstmt.setInt(3, su);
      pstmt.setInt(4, dan);

      int n = pstmt.executeUpdate();

      if (n == 1) {
        System.out.println("상품 추가 성공");
      } else {
        System.out.println("상품 추가 실패!");
      }
      System.out.println("db에 추가되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(pstmt, conn);
    }
  }

  public void writeSangpum() {
    Connection conn = db.getOracle();
    PreparedStatement ps = null;
    ResultSet rs = null;

    String sql = "select * from sales order by num asc";

    try {
      ps = conn.prepareStatement(sql);
      rs = ps.executeQuery();

      System.out.println("시퀀스\t타입\t상품명\t수령\t단가\t입고일");
      System.out.println("-------------------------------------");

      while (rs.next()) {
        System.out
            .println(rs.getInt("num") + "\t" + rs.getString("type") + "\t" + rs.getString("sangpum")
                + "\t" + rs.getInt("su") + "\t" + rs.getInt("dan") + "\t" + rs.getDate("ipgo"));
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(rs, ps, conn);
    }
  }

  public void deleteSangpum() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("삭제할 번호는?");
    int deleteNum = Integer.parseInt(stdIn.nextLine());

    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    String sql = "delete from sales where num = ?";

    try {
      ps = conn.prepareStatement(sql);
      ps.setInt(1, deleteNum);
      int n = ps.executeUpdate();

      System.out.println(n + "행이 삭제되었습니다.");
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      db.dbClose(ps, conn);
    }
  }

  public void updateSangpum() {
    Connection conn = db.getOracle();
    PreparedStatement ps = null;

    System.out.println("수정할 시퀀스 번호는?");
    int num = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 데이터 입력");
    System.out.println("1.음료 2.과일 택 1");
    int type = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 상품 명은?");
    String sang = stdIn.nextLine();
    System.out.println("수정할 수량은?");
    int su = Integer.parseInt(stdIn.nextLine());
    System.out.println("수정할 단가는?");
    int dan = Integer.parseInt(stdIn.nextLine());

    String sql = "update sales set type = ?, sangpum = ?, su = ?, dan = ? where num = ?";
    try {
      ps = conn.prepareStatement(sql);
      ps.setString(1, type == 1 ? "음료" : "과일");
      ps.setString(2, sang);
      ps.setInt(3, su);
      ps.setInt(4, dan);
      ps.setInt(5, num);
      
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
    Ex05_PrepareSales ex = new Ex05_PrepareSales();
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
          ex.insertSangpum();
          break;
        case 2:
          ex.deleteSangpum();
          break;
        case 3:
          ex.updateSangpum();
          break;
        case 4:
          ex.writeSangpum();
          break;
      }
    }
  }
}
