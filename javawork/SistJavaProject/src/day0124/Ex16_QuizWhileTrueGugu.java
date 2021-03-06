package day0124;

import java.util.Scanner;

public class Ex16_QuizWhileTrueGugu {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = 0;
    
    while (true) {
      System.out.print("단을 입력하시오(종료: 0): ");
      n = stdIn.nextInt();
      if (n == 0) {
        break;
      }
      if (n > 9 || n < 2) {
        System.out.println("2 ~ 9단 중으로 입력하세요");
        continue;
      }
      
      System.out.println("[" + n + "단]");
      for (int i = 1; i <= 9; i++) {
        System.out.println(n + "X" + i + "=" + i * n);
      }
    }
  }
}
