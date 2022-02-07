package day0207;

public class Manager extends Ex04_Employee {

  String depart;
  
  public Manager(String n, int s, String d) {
    super(n, s);
    this.depart = d;
  }

  @Override
  public String getEmployee() {
    // TODO Auto-generated method stub
    return super.getEmployee() + "," + this.depart;
  }
  
  
}
