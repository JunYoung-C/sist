package day0203;

public class Member {
  private String name;
  private String gender;
  private String addr;
  
  static String CLASS = "JAVA반";
  static int cnt = 0;
  
  public void setData(String name, String gender, String addr) {
    this.name = name;
    this.gender = gender;
    this.addr = addr;
  }
  
  public void write() {
    System.out.println("[학생" + ++cnt + "정보]");
    System.out.println("이름: " + name);
    System.out.println("소속반: " + CLASS);
    System.out.println("성별: " + gender);
    System.out.println("주소: " + addr);
  }
}
