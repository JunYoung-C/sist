package day0128;

public class Ex05_MemoryCount {
  
  int count = 0;
  static int cnt = 0;
  
  
  public Ex05_MemoryCount() {
    count++;
    cnt++;
    System.out.println("인스턴스 변수 :" + count);
    System.out.println("static 변수 : " + cnt);
  }



  public static void main(String[] args) {
    // 각각 서로 다른 메모리를 가지므로 인스턴스는 카운트가 증가하지 않는다.
    Ex05_MemoryCount mc1 = new Ex05_MemoryCount();
    Ex05_MemoryCount mc2 = new Ex05_MemoryCount();
    
    // static 변수는 공용으로 가지므로 카운트가 증가한다.
  }
}
