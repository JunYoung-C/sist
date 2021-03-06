package day0120;

import java.util.Scanner;

public class Ex10_IfScan {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    int score;
    String msg, grade;

    System.out.println("점수를 입력하세요");
    score = stdIn.nextInt();

    msg = score >= 90 ? "상품권 10만원" : score >= 80 ? "상품권 5만원" : "다음기회에 ... 재시험";
    if (score >= 90) {
      grade = "A";
    } else if (score >= 80) {
      grade = "B";
    } else if (score >= 70) {
      grade = "C";
    } else if (score >= 60) {
      grade = "D";
    } else {
      grade = "F";
    }

    System.out.println("점수: " + score);
    System.out.println("평가 메시지: " + msg);
    System.out.println("학점: " + grade);
  }
}
