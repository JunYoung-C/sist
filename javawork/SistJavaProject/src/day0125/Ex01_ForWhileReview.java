package day0125;

import java.util.Scanner;

public class Ex01_ForWhileReview {

  public static void test1() {

    // for문으로 1부터 5까지를 더하기
    int sum = 0;
    for (int i = 0; i <= 5; i++) {
      sum += i;
    }
    System.out.println(sum);
  }

  public static void test2() {
    int sum = 0;
    for (int i = 1; i <= 10; i++) {
      if (i % 2 == 1) {
        sum += i;
      }
    }
    System.out.println("홀수의 합 " + sum);
  }

  public static void test3() {
    int i = 1;
    int sum = 0;
    for (; i <= 10; i++) {
      sum += i;
    }
    System.out.println("출력은 " + (i - 1) + "까지의 합은" + sum + "입니다.");
  }


  public static void test4() {
    int i = 0;
    int sum = 0;
    while (true) {
      i++;
      if (i % 2 == 1)
        continue;

      sum += i;

      if (i >= 10) {
        break;
      }
    }
    System.out.println("1~" + i + "까지 짝수의 합은" + sum);
  }

  public static void ScanSum5() {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("3개의 숫자를 입력해 주세요");
    int[] arr = new int[3];
    int sum = 0;
    for (int i = 1; i <= 3; i++) {
      System.out.print(i + "번째 정수 : ");
      int num = stdIn.nextInt();
      if (num < 1 || num > 100) {
        System.out.println("1부터 100까지의 숫자를 입력해주세요");
        i--;
        continue;
      }
      sum += num;
    }

    System.out.println("총합계: " + sum);
  }

  public static void main(String[] args) {
    // test1();
    // test2();
    // test3();
    // test4();
    ScanSum5();
  }
}
