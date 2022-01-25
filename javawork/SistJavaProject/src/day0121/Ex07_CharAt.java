package day0121;

import java.util.Scanner;

public class Ex07_CharAt {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    char ch;
    System.out.println("알파뱃 1글자 입력");
    
    ch = stdIn.nextLine().charAt(0);
    System.out.println("ch = " + ch);
    
    switch (ch) {
      case 'a':
      case 'A':
        System.out.println("Apple");
        break;
      case 'o':
      case 'O':
        System.out.println("Orange");
        break;
      case 'b':
      case 'B':
        System.out.println("Banana");
        break;
      default:
        System.out.println("other fruit");
        break;
    }
  }
}
