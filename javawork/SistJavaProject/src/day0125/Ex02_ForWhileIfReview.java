package day0125;

import java.util.Scanner;

public class Ex02_ForWhileIfReview {

  public static void ScanFactorial_1() {
    Scanner stdIn = new Scanner(System.in);
    int num = stdIn.nextInt();
    int sum = 1;
    for (int i = num; i >= 1; i--) {
      sum *= i;
    }
    System.out.println(num + "! : " + sum);
  }

  public static void ScanString_2() {
    Scanner stdIn = new Scanner(System.in);
    String name;
    int cnt = 0;
    while (true) {
      System.out.println("이름입력(종료=끝)");
      name = stdIn.next();
      
      if (name.equals("끝")) {
        break;
      }
      
      if (name.startsWith("김")) {
        cnt++;
      }
    }
    System.out.println("김씨 성을 가진 사람은 총 " + cnt + "명 입니다.");
  }
  
  public static void ScanWhileTrue_3() {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("합계를 구할 숫자를 입력하시오");
    int num = stdIn.nextInt();
    int sum = 0;
    int i = 0;
    while (true) {
      i++;
      sum += i;
      if (i >= num) {
        break;
      }
    }
    
    System.out.println("1~" + num + "까지의 합은 " +sum + "입니다.");
  }

  public static void main(String[] args) {
//    ScanFactorial_1();
//    ScanString_2();
    ScanWhileTrue_3();
  }
}
