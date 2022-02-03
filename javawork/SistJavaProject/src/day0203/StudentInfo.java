package day0203;

public class StudentInfo {
  private String stuName;
  private String hp;
  private int score;
  
  public StudentInfo() {
    this("홍길동", "010-222-4333", 99);
  }
  public StudentInfo(String name, String hp) {
    this(name, hp, 77);
  }
  public StudentInfo(String name, String hp, int score) {
    this.stuName = name;
    this.hp = hp;
    this.score =score;
  }
  
  public void writeData() {
    System.out.println("이름: " + stuName);
    System.out.println("핸드폰: " + this.hp);
    System.out.println("점수: " + this.score);
  }
}
