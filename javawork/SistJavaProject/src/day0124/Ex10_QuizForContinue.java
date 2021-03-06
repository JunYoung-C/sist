package day0124;

import java.util.Scanner;

public class Ex10_QuizForContinue {
  public static void main(String[] args) {
    // 총 5대의 점수를 입력받아서 합계를 구한다.
    // 만약 1 ~ 100이 아닐 경우 다시 입력받으시오
    Scanner stdIn = new Scanner(System.in);

    int num = 0;
    int sum = 0;
    System.out.println("5개의 정수를 입력하시오(1 ~ 100)");
    for (int i = 1; i <= 5; i++) {
      System.out.print(i + "번 점수: ");
      num = stdIn.nextInt();
      if (num < 1 || num > 100) {
        i--;
        System.out.println("잘못 입력했어요.");
        continue;
      }
      sum += num;
    }
    System.out.println("총점 : " + sum);
  }
}
