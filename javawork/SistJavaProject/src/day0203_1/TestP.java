package day0203_1;

public class TestP {
  private TestP() {
    System.out.println("디폴트 생성자");
  }
  
  public static TestP getInstance() {
    return new TestP();
  }
  
  public void writeMessage() {
    System.out.println("안녕하세요.");
    System.out.println("일반 메서드입니다.");
  }
}
