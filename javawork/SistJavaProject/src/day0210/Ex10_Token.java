package day0210;

import java.util.StringTokenizer;

public class Ex10_Token {
  public static void main(String[] args) {
    String str = "red,blue,yello,white,pink,purple,orange";
    System.out.println("String 객체에서 split을 이용한 분리");
    String[] arr = str.split(",");
    System.out.println("총" + arr.length + "개");
    for (int i = 0; i < arr.length; i++) {
      System.out.println(i + ":" + arr[i]);
      
    }
    
    System.out.println("StringTokenizer를 이용한 분리");
    StringTokenizer st = new StringTokenizer(str, ",");
    System.out.println("총 토큰 수: " + st.countTokens());
    while(st.hasMoreTokens()) {
      System.out.println(st.nextToken());
    }
  }
}
