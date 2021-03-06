package day0203;

class MyInfo {
  private String name;
  private int age;
  public static final String ADDR = "Seoul";

  public String getName() {
    return name;
  }

  public void write() {
    System.out.println("이름: " + this.name + ", 나이: " + this.age);
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setData(String name, int age) {
    this.name = name;
    this.age = age;
  }
}


public class Ex05_ObMethod {
  public static void main(String[] args) {
    MyInfo me = new MyInfo();
    me.setName("유재석");
    me.setAge(34);
    System.out.println("이름1: " + me.getName());
    System.out.println("나이1: " + me.getAge());

    MyInfo me2 = new MyInfo();
    me2.setData("하하", 37);
    me2.write();
  }
}
