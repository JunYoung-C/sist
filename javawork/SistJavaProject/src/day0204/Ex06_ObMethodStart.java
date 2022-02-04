package day0204;

public class Ex06_ObMethodStart {

  public static void good(int age) {
    System.out.println("안녕 좋은 아침");
    System.out.println("나의 나이는 " + age + "세입니다.");
    
  }
  
  public static void main(String[] args) {
    System.out.println("자바 시작!!");
    good(22);
    good(33);
    System.out.println("자바 끝");
  }
  
  public static void hello(String name) {
    System.out.println("반가워~~");
    System.out.println("나의 이름은" + name + "이야");
  }
}

