package day0121;

public class Ex10_For {
  public static void main(String[] args) {
    // for(초기값; 조건문; 증감식) {
    // }
    // 초기값 -> 조건문 -> 블록 -> 증감식 -> 조건문 -> 조건문이 false가 될 때까지 반복
    
    for (int i = 0; i < 5; i++) {
      System.out.print(i + " ");
    }
    
    for (int i = 1; i <= 10; i++) {
      System.out.println("Hello" + i);
    }
    System.out.println("for문을 빠져나옴");
  }
}
