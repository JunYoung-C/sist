package day0207;

abstract public class Ex09_Fruit {
  public static final String MESSAGE = "오늘을 상혹 배우는날~";

  public void showTitle() {
    System.out.println("우리는 추상 클래스를 배웁니다.");
  }

  // 추상메서드
  // 미완의 메서드
  // 오버라이딩이 목적이므로 몸통없이 선언만 한다.
  abstract public void showMessage();
}
