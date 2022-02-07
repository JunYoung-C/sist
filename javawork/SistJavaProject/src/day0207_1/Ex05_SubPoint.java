package day0207_1;

import day0207.Ex05_SuperPoint;

public class Ex05_SubPoint extends Ex05_SuperPoint{
  
  String message;
  
  public Ex05_SubPoint() {
    super();
    System.out.println("subpoint-디폴트 생성자 호출");
  }

  public Ex05_SubPoint(int x, int y, String message) {
    super(x, y);
    this.message = message;
  }

  @Override
  public void write() {
    // TODO Auto-generated method stub
    super.write();
    System.out.println("메세지: " + message);
  }
  
  
}
