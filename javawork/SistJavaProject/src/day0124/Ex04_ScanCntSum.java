package day0124;

import java.util.Scanner;

public class Ex04_ScanCntSum {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    // 총 횟수와 입력한 값의 합을 구할 것
    int num;
    int cnt = 0;
    int sum = 0;
    while (true) {
      System.out.println("숫자 입력(종료:0)");
      num = stdIn.nextInt();
      
      if (num == 0) {
        System.out.println("총 입력한 개수:" + cnt);
        System.out.println("입력한 숫자의 합: " + sum);
        double avg = (double) sum / cnt;
        System.out.printf("평균: %.1f", avg);
        break;
      }

      cnt++;
      sum += num;
    }
  }
}
