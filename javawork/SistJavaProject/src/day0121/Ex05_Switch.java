package day0121;

import java.util.Scanner;

public class Ex05_Switch {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println("숫자 입력");
    int num = stdIn.nextInt();
    
    switch (num) {
      case 1:
        System.out.println("1 입력됨");
        break;
      case 2:
        System.out.println("2 입력됨");

      case 3:
        System.out.println("3 입력됨");
        
      default:
        System.out.println("항상 출력");
        break;
    }
    
    switch (num % 2) {
      case 0:
        System.out.println("짝수");
        break;

      default:
        break;
    }
  }
}
