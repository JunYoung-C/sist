package day0124;

import java.util.Scanner;

public class Ex17_Mul {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    int x, y;
    
    System.out.println("두 수를 입력하세요");
    x = stdIn.nextInt();
    y = stdIn.nextInt();
    
    int result = 1;
    for (int i = 1; i <= y; i++) {
      result *= x;
    }
    System.out.println(x + " 의 " + y + "승은" + result + " 입니다.");
  }
}
