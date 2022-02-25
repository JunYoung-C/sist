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

  
  public static void main(String[] args) {
    Ex05_PrepareSales ex = new Ex05_PrepareSales();
    ex.insertSangpum();
  }
}
