package day0209;

import java.util.Scanner;

public class Ex07_ThrowsExcep {
  public static void scoreInput() throws Exception {
    Scanner stdIn = new Scanner(System.in);
    
    int score = 0;
    System.out.println("점수를 입력하세요");
    score = stdIn.nextInt();
    
    if (score < 0 || score > 100) {
      throw new Exception("점수가 잘못 입력되었어요.");
    } else {
      System.out.println("나의 점수는 " + score + "입니다.");
    }
  }
  public static void main(String[] args) {
    try {
      scoreInput();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("정상 종료");
  }
}
