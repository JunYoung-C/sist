package day0121;

import java.util.Scanner;

public class Ex02_IfMax {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("3개의 수를 입력하세요");
    int a = stdIn.nextInt();
    int b = stdIn.nextInt();
    int c = stdIn.nextInt();

    int max = a;
    if (max < b) {
      max = b;
    }
    if (max < c) {
      max = c;
    }

    System.out.println("max = " + max);
  }
}
