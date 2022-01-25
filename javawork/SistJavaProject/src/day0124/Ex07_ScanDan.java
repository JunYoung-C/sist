package day0124;

import java.util.Scanner;

public class Ex07_ScanDan {
  public static void main(String[] args) {
    // 구구단 중 원하는 단만 출력할 것
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println("원하는 구구단은?");
    int n = stdIn.nextInt();
    
    System.out.println(n + "단");
    for (int i = 1; i <= 9; i++) {
      System.out.println(n + "X" + i + "=" + n * i);
    }
  }
}
