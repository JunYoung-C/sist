package day0204;

import java.util.Scanner;

class Student {
  private String name;
  private int java;
  private int oracle;
  private static String schoolName;
  private int cnt = 2; // 자바, 오라클

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getJava() {
    return java;
  }

  public void setJava(int java) {
    this.java = java;
  }

  public int getOracle() {
    return oracle;
  }

  public void setOracle(int oracle) {
    this.oracle = oracle;
  }

  public static String getSchoolName() {
    return schoolName;
  }

  public static void setSchoolName(String schoolName) {
    Student.schoolName = schoolName;
  }

  public int getTotal() {
    return java + oracle;
  }

  public double getAvg() {
    return (double) getTotal() / cnt;
  }

  public String getPungga() {
    double avg = getAvg();
    if (avg >= 90) {
      return "장학생";
    } else if (avg >= 80) {
      return "합격";
    } else {
      return "불합격";
    }
  }
}


public class QuizWeekStu {
  public static void writeResult(Student[] students, int n) {
    System.out.println("**결과 출력**");
    System.out.println("학교명: " + Student.getSchoolName());
    System.out.println("학생명\tJAVA\tORACLE\t총점\t평균\t평가");
    System.out.println("===========================================");
    for (int i = 0; i < n; i++) {
      Student s = students[i];
      System.out.println(s.getName() + "\t" + s.getJava() + "\t" + s.getOracle() + "\t"
          + s.getTotal() + "\t" + (int)s.getAvg() + "\t" + s.getPungga());
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("학교명");
    Student.setSchoolName(stdIn.next());
    System.out.println("학생인원");
    int n = stdIn.nextInt();
    Student[] students = new Student[n];

    for (int i = 0; i < n; i++) {
      System.out.println(i + "번 학생 이름");
      String name = stdIn.next();
      System.out.println("자바 점수와 오라클 점수");
      int java = stdIn.nextInt();
      int oracle = stdIn.nextInt();

      Student s = new Student();
      s.setName(name);
      s.setJava(java);
      s.setOracle(oracle);

      students[i] = s;
      
      System.out.println();
    }

    writeResult(students, n);
  }
}
