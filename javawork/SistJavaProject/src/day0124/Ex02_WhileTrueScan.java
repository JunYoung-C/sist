package day0124;

import java.util.Scanner;

public class Ex02_WhileTrueScan {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int num;
    int i = 0;
    int sum = 0;
    System.out.println("합계를 구할 숫자를 입력하시오");
    num = stdIn.nextInt();
    
    while (true) {
      sum += i++;
      
      if (i > num) {
        break;
      }
    }
    
    System.out.println(i - 1 + " " + sum);
  }
}
