package day0121;

import java.util.Scanner;

public class Ex04_IfStringOper {
  public static void main(String[] args) {
    // 문자열 비교는 관계 엔산자로 하면 안되고
    // equals라는 메서드를 사용해서 비교한다.
    
    Scanner stdIn = new Scanner(System.in);
    
    String msg;
    System.out.println("영어 단어를 입력하세요");
    System.out.println("입력 단어에 예) happy, angel");
    msg = stdIn.next();
    
    System.out.println("입력한 문자열 : " + msg);
    // 문자열 동등연산자로 비교하려면 주소 비교를 함. 
    if (msg.equalsIgnoreCase("happy")) {
      System.out.println("happy네요");
    } else if(msg.equalsIgnoreCase("angel")) {
      System.out.println("천사네요");
    } else {
      System.out.println("기타네요");
    }
    
  }
}
