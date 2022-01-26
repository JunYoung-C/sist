package day0126;

public class Ex03_ArraysString {
  public static void main(String[] args) {
    String[] str;
    str = new String[4];
    
    str[0] = "홍길동";
    str[1]= "유재석";
    str[2] = "이승기";
    
    for (int i = 0; i < 4; i++) {
      System.out.println(str[i]);
    }
  }
}
