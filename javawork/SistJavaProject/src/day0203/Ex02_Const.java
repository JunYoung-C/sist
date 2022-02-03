package day0203;

// 생성자 - 객체 생성시 자동 호출되는 메서드

// 일반 메서드와 차이점 : 리턴형이 없다.
// 클래스명과 같다.
// OverLoading이 가능
// 생성자 끼리의 호출을 this(). this()는 반드시 첫줄
class Apple {
  public Apple() {
    System.out.println("디폴트 생성자 호출");
  }
}


class Banana {
  public Banana(String str) {
    System.out.println("생성자 호출 : " + str);
  }
}


class Orange {
  public Orange() {
    System.out.println("오렌지 디폴트 생성자 호출");
  }

  public Orange(String str) {
    System.out.println("오렌지 두번째 생성자 호출: " + str);
  }

  public Orange(int n) {
    this();
    System.out.println("오렌지 세번째 생성자 호출 : " + n);

  }
}


public class Ex02_Const {
  public static void main(String[] args) {
    Apple ap = new Apple();
    Banana ba = new Banana("Happy");
    
    Orange or1 = new Orange();
    Orange or2 = new Orange("Hello");
    Orange or3 = new Orange(5);
  }
}
