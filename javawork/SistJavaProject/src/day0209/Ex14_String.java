package day0209;

import java.util.Scanner;

public class Ex14_String {
  public static void main(String[] args) {
    String[] names = {"김은비", "곽경태", "차동현", "이다솔", "김주찬", "김민지", "이강진", "김태민", "차두리"};

    Scanner stdIn = new Scanner(System.in);
    String name = "";
    int cnt = 0;
    while (true) {
      System.out.println("검색할 이름(일부만도 됨)");
      name = stdIn.next();
      if (name.equalsIgnoreCase("q")) {
        System.out.println("종료합니다.");
        break;
      }
      
      for (String s : names) {
        if (s.startsWith(name)) {
          cnt++;
          System.out.println(s);
        }
          
      }
      
    }
  }
}
