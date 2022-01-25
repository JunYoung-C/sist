package day0125;

import java.util.Scanner;

public class Ex05_QuizOper {
  public static void ex_01() {
    Scanner stdIn = new Scanner(System.in);
    
    int num;
    int pCnt = 0;
    int nCnt = 0;
    
    System.out.println("10개의 숫자를 입력하세요");
    for (int i = 1; i <= 10; i++) {
      System.out.print(i + ": ");
      num = stdIn.nextInt();
      if (num > 0) {
        pCnt++;
      } else {
        nCnt++;
      }
    }
    
    System.out.println("================================");
    System.out.println("양수 갯수 : " + pCnt);
    System.out.println("음수 갯수 : " + nCnt);
  }
  
  public static void ex_02() {
    int sum = 0;
    int i = 0;
    while (true) {
      i++;
      if (i % 2 == 0) {
        sum += i;
        continue;
      }
      if (i >= 100) {
        break;
      }
    }
    System.out.println("1 ~ 100까지 짝수의 합 : " + sum);
  }
  
  public static void ex_03() {
    int cnt = 0;
//    for (int i = 1; i <= 100; i++) {
//      if (i % 3 == 0) {
//        cnt++;
//      }
//    }
    
    int i = 0;
    while (true) {
      i++;
      if (i % 3 == 0) {
        cnt++;
      }
      if (i >= 100) {
        break;
      }
    }
    System.out.println("1부터 100까지의 3의 배수의 개수: " + cnt);
  }
  
  public static void ex_04() {
    int i = 1;
    int mul = 1;
    while(true) {
      mul *= i;
      System.out.println(i + "!=" + mul);
      i++;
      if (i > 10) {
        break;
      }
    }
  }
  
  public static void main(String[] args) {
//    ex_01();
//    ex_02();
//    ex_03();
    ex_04();

  }
} 
