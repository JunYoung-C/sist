package day0120;

import java.util.Scanner;

public class Ex03_Oper {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    int x, y;
    
    System.out.println("두수를 입력해 주세요");
    x = stdIn.nextInt();
    y = stdIn.nextInt();
    
    System.out.println("더하기=" + (x + y));
    System.out.println("빼기=" + (x - y));
    System.out.println("곱하기=" + (x * y));
    System.out.println("나누기=" + ((double)x / y));
    System.out.println("나머기=" + (x % y));
  }
}
