package day0207;

public class Ex05_SuperPoint {
  protected int x;
  protected int y;

  public Ex05_SuperPoint() {
    System.out.println("super-디폴트생성자 호출");
  }
  
  public Ex05_SuperPoint(int x, int y) {
    System.out.println("super-인자있는 생성자 호출");
    this.x = x;
    this.y = y;
  }
  
  public void write() {
    System.out.println("x좌표=" + x + ", y좌표=" + y);
  }
}
