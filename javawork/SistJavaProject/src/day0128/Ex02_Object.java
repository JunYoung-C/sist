package day0128;

public class Ex02_Object {

  // 인스턴스 변수, 객체 생성 후 각각 다른 값을 가질 수 있다.
  String name;

  // 여러 객체가 같은 값을 가져야 할 경우 static 주로 선언
  // 객체 생성 없이 접근 가능하다. 클래스명.변수로 접근
  static String MESSAGE = "Happy Day!!";

  public static void main(String[] args) {
    System.out.println("static 멤버 변수는 new로 생성 없이 호출 가능하다.");
    System.out.println(Ex02_Object.MESSAGE);
    System.out.println(MESSAGE); // 같은 클래스 내에서는 클래스명 생략 가능
    
    // 인스턴스 벼수는 객체 생성 없이 멤버 접근 불가능
    Ex02_Object kd = new Ex02_Object();
    kd.name = "홍길동";
    System.out.println(kd.name);
  }
}
