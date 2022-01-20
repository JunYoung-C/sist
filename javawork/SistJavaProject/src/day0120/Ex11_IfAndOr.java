package day0120;

import java.util.Scanner;

public class Ex11_IfAndOr {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println("이름을 입력하세요");
    String name = stdIn.next();
    
    System.out.println("3과목의 점수를 입력하세요");
    int oracle = stdIn.nextInt();
    int java = stdIn.nextInt();
    int eng = stdIn.nextInt();
    
    int sum = oracle + java + eng;
    double avg = (double) sum / 3;
    
    System.out.println("****시험 결과****");
    System.out.println("오라클, 자바, 자바 영어 점수: " + oracle + ", " + java + ", " + eng);
    System.out.printf("평균: %.1f점\n", avg);
    System.out.println("합격 조건은 편균이 60점 이상이고\n각과목이 모두 40점 이상이면 합격");
    System.out.println("===============================================");
    
    String result;
    if (avg >= 60 && oracle >= 40 && java >= 40 && eng >= 40) {
      result = "합격";
    } else {
      result = "불합격";
    }
    
    System.out.println(result);
  }
}
