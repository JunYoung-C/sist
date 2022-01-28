package day0128;

public class Ex04_StuInfoTest {
  public static void main(String[] args) {

    System.out.println("**클래스 멤버값 출력**");
    StudentInfo.schoolName = "쌍용고등학교";
    StudentInfo student1 = new StudentInfo();
    StudentInfo student2 = new StudentInfo();
    
    student1.name = "곽경태";
    student1.age = 18;
    student2.name = "임현정";
    student2.age = 19;
    System.out.println("학교 : " + StudentInfo.schoolName);
    System.out.println("학생1 정보");
    System.out.println("이름: " + student1.name + ", 나이: " + student1.age + "세");
    System.out.println("학생2 정보");
    System.out.println("이름: " + student2.name + ", 나이: " + student2.age + "세");
  }
}
