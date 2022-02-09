package day0209;

public class Ex06_Thread {
  public static void main(String[] args) {
    System.out.println("안녕하세요");
    System.out.println("5초 후 헤어집시다.");
    try {
      Thread.sleep(5000);
      System.out.println();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    System.out.println("안녕히가세요");
  }
}
