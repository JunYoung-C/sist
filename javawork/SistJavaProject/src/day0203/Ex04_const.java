package day0203;

class Person {
  String name;
  int age;

  public Person() {
    this("이수연", 5);
  }

  public Person(String name) {
    this(name, 5);
  }

  public Person(int age) {
    this("이수연", age);
  }

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
    System.out.println("호출");
  }

  public void write() {
    System.out.println("이름: " + name + "\t나이: " + age);
  }
}


public class Ex04_const {
  public static void main(String[] args) {
    Person p1 = new Person();
  }
}
