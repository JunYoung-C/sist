package day0128;

public class Ex09_StudentTest {
  public static void main(String[] args) {
    // 1. 객체 생성
    // 클래스명 참조변수명 = new 클래스명([값]);
    // 참조변수명.변수명; (private은 접근 안됨)
    // 참조변수명.메소드명;
    
    Student stu1 = new Student();
    stu1.setName("임현정");
    stu1.setAge(20);
    
    String name = stu1.getName();
    int age = stu1.getAge();
    System.out.println(name + ", " + age);
    
    Student stu2 = new Student("이다솔", 23);
  }
}
