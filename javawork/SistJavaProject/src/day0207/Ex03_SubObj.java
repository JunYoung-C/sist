package day0207;

public class Ex03_SubObj extends Ex03_SuperObj {

  private String addr;
  
  public Ex03_SubObj(String name, int age, String addr) {
    super(name, age);
    this.addr = addr;
  }
}
