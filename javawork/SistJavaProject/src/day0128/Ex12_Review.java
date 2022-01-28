package day0128;

class MyFriends {
  private String name;
  private String addr;
  private String hp;
  
  public static final String schoolName = "쌍용고동창회모임";

  public MyFriends(String name, String addr, String hp) {
    super();
    this.name = name;
    this.addr = addr;
    this.hp = hp;
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

  public String getHp() {
    return hp;
  }

  public void setHp(String hp) {
    this.hp = hp;
  }

  public static String getSchoolname() {
    return schoolName;
  }
  
  
}
public class Ex12_Review {
  public static void main(String[] args) {
    System.out.println("[" + MyFriends.schoolName + "]");
    MyFriends p1 = new MyFriends("강나리", "경기도 수원시", "010-3333-4444");
    System.out.println("이름: " + p1.getName());
    System.out.println("주소: " + p1.getAddr());
    System.out.println("핸드폰: " + p1.getHp());
    System.out.println("------------------------------");
    MyFriends p2 = new MyFriends("김은비", "서울시 은평구", "010-1111-9999");
    System.out.println("이름: " + p2.getName());
    System.out.println("주소: " + p2.getAddr());
    System.out.println("핸드폰: " + p2.getHp());

  }
}
