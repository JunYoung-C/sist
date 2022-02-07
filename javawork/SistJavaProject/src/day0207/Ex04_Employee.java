package day0207;

public class Ex04_Employee {

  String name;
  int salary;
  public Ex04_Employee(String name, int salary) {
    super();
    this.name = name;
    this.salary = salary;
  }
  
  public String getEmployee() {
    return this.name + "," + this.salary;
  }
}
