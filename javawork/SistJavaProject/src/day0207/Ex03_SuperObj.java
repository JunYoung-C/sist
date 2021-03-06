package day0207;

// 부모클래스가 다른 패키지에 있을 때 protected, public 변수는 접근 가능하다.
// 같은 패키지인 경우에는 private 빼고 전부 접근 가능

public class Ex03_SuperObj {
  protected String name;
  protected int age;

  public Ex03_SuperObj(String name, int age) {
    super();
    this.name = name;
    this.age = age;
  }
  
  public void writeData() {
    System.out.println(this.name);
    System.out.println(this.age);
  }
}
