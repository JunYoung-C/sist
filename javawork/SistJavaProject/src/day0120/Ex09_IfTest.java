package day0120;

public class Ex09_IfTest {
  public static void main(String[] args) {
    int n = 10;

    // if (n > 5) {
    // System.out.println("n은 5보다 크다");
    //
    // }

    // if (n % 2 == 0) {
    // System.out.println(n + "은 짝수이다.");
    // } else {
    // System.out.println(n + "은 홀수이다.");
    // }

    int score = 67;
    // char grade = 'A';
    //
    // if (score >= 90) {
    // grade = 'A';
    // } else if (score >= 80) {
    // grade = 'B';
    // } else if (score >= 70) {
    // grade = 'C';
    // } else if (score >= 60) {
    // grade = 'D';
    // } else {
    // grade = 'E';
    // }

    // 삼항 연산자 이용하여 학점 구하기
    String grade;

    grade = score >= 90 ? "A" : "etc";

    System.out.println("나의 학점은 " + grade + "입니다.");
  }
}
