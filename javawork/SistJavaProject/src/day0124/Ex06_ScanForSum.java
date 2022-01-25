package day0124;

import java.util.Scanner;

public class Ex06_ScanForSum {
  public static void main(String[] args) {
    // 숫자 n울 입력받으면 1부터  n까지의 합계 구하기(for)
    Scanner stdIn = new Scanner(System.in);
    System.out.println("합계를 구할 숫자를 입력하시오");
    int num = stdIn.nextInt();
    int sum = 0;
    
    for (int i = 1; i <= num; i++) {
      sum += i;
    }
    
    System.out.println("1 ~ " + num + "까지의 합은 " + sum + "입니다.");
  }
}
