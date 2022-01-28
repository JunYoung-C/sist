package day0128;

class ObConstAA {
  String name;
  String addr;

  public ObConstAA(String name) {
    this(name, "서울시"); // 생성자에서 다른 오버로딩 생성자를 호출하는 경우
    // 반드시 생성자 첫 라인에서 사용
  }

  public ObConstAA(String name, String addr) {
    super();
    this.name = name; // 인스턴스 자기 자신을 this라 함. 이름이 동일할 때는 반드시 표기
    this.addr = addr;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

}


public class Ex10_ObConstTest {
  public static void main(String[] args) {
    ObConstAA ob1 = new ObConstAA("홍길동");
    System.out.println("이름은" + ob1.getName() + "이며 주소는" + ob1.getAddr() + "입니다.");
    ObConstAA ob2 = new ObConstAA("김기열", "경기도 용인시");
    System.out.println("이름: " +ob2.getName() + ", 주소: " + ob2.getAddr());
  }
}
