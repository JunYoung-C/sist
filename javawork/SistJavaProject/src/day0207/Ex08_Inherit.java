package day0207;

class School {
  private String schoolAddr; // 학교주소
  private int countStu; // 학생 수
  private int countTeacher; // 교사 수
  public static final String SCHOOLNAME="노원고등학교";
  
  public School() {
    this("노원구", 200, 20);
  }
  public School(String schoolAddr, int countStu, int countTeacher) {
    super();
    this.schoolAddr = schoolAddr;
    this.countStu = countStu;
    this.countTeacher = countTeacher;
  }
  public String getSchoolAddr() {
    return schoolAddr;
  }
  public void setSchoolAddr(String schoolAddr) {
    this.schoolAddr = schoolAddr;
  }
  public int getCountsu() {
    return countStu;
  }
  public void setCountstu(int countStu) {
    this.countStu = countStu;
  }
  public int getCountTeacher() {
    return countTeacher;
  }
  public void setCountTeacher(int countTeacher) {
    this.countTeacher = countTeacher;
  }
  public static String getSchoolname() {
    return SCHOOLNAME;
  }
  
  public void writeData() {
    System.out.println("학교수조: " + schoolAddr);
    System.out.println("학생수: " + countStu + ", 교사수: " + this.countTeacher);
  }
}

class Student extends School {
  private String stuName;
  private int score;
  
  public Student() {
    
  }

  public String getStuName() {
    return stuName;
  }

  public void setStuName(String stuName) {
    this.stuName = stuName;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }
  
  @Override
  public void writeData() {
    System.out.println("학교명: " + SCHOOLNAME);
    super.writeData();
    System.out.println("학생명: " + stuName);
    System.out.println("성정: " + score);
  }
}
public class Ex08_Inherit {
  public static void main(String[] args) {
    Student s1 = new Student();
    s1.writeData();
  }
}
