package day0121;

public class Ex13_DoWhile {
  public static void main(String[] args) {
    int i = 1;
    
    System.out.println("while 문 결과");
    
    while (i < 5) {
      System.out.println(i++);
    }
    
    i = 100;
    do {
      System.out.println(i++);
    } while (i < 5);
  }
}
