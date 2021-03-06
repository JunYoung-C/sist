package day0203;

public class Ex10_StudentInfoTest {
  public static void main(String[] args) {
    StudentInfo[] students = new StudentInfo[3];
    
    students[0] = new StudentInfo();
    students[1] = new StudentInfo("이순신", "010-2222-9999");
    students[2] = new StudentInfo("조민진", "010-2222-6666", 88);
    
    for (int i = 0; i < students.length; i++) {
      StudentInfo student = students[i];
      student.writeData();
      System.out.println("------------------");
      
      System.out.println(students[i] == student);
    }
  }
}
