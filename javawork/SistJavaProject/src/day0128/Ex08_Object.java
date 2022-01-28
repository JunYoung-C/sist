package day0128;


class ObTestA {
  private int x;
  private static int y;
  
  // 메서드로 접근 가능(캡슐화). 인스턴스 변수가 private이면 생성을 해도 참조 변수로 변수에 접근 못함.
  
  // 멤버 수정 메서드
  public void setX(int xx) {
    this.x = xx;
  }
  
  // 멤버 출력 메서드
  public void getX() {
    System.out.println("x=" + this.x);
  }
  
  public static void setY(int yy) {
    y = yy;
  }
  
  public static void getY() {
    
    System.out.println("y=" + ObTestA.y);
  }
}
public class Ex08_Object {
  public static void main(String[] args) {
    ObTestA obA1 = new ObTestA();
    obA1.setX(10);
    obA1.getX();
    
    ObTestA obA2 = new ObTestA();
    obA2.setX(33);
    obA2.getX();

    ObTestA.setY(100);
    ObTestA.getY();
  }
}
