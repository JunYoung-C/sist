package day0207;


class Sawon extends Ex06_Person {
  int age;
  
  public Sawon(String name, String buseo, int age) {
    this.name = name;
    this.buseo = buseo;
    this.age = age;
  }

  @Override
  public void display() {
    // TODO Auto-generated method stub
    super.display();
    System.out.println("나이: " + this.age);
  }
  
  public void write() {
    System.out.println(this.name + "님의 부서는" + this.buseo + "부서이며 나이는 " + age + "세 입니다.");
  }
}
public class Ex06_Inherit {
  
}
