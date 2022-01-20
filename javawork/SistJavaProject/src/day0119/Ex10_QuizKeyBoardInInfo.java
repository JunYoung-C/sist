package day0119;

import java.util.Calendar;
import java.util.Scanner;

public class Ex10_QuizKeyBoardInInfo {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    System.out.print("응시자 이름: ");
    String name = stdIn.nextLine();
    System.out.print("출생년도: ");
    int year = Integer.parseInt(stdIn.nextLine());

    System.out.print("학과: ");
    String cl = stdIn.nextLine();
    System.out.print("소프트웨어 사전시험결과: ");
    int sw = Integer.parseInt(stdIn.nextLine());
    System.out.print("실전 응용테스트: ");
    int app = Integer.parseInt(stdIn.nextLine());
    
    Calendar cal = Calendar.getInstance();
    
    int curYear = cal.get(cal.YEAR);
    int age = curYear - year + 1;
    int sum = sw + app;
    double avg = (double) sum / 2;
    
    System.out.println("[시험결과]\n");
    System.out.println("학과: " + cl);
    System.out.println("응시자명: " + name);
    System.out.println("나이: " + age + "세");
    System.out.printf("시험결과 평균 %.1f", avg);
  }
}
