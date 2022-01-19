package day0119;

import java.util.Scanner;

public class Ex08_ScanScoreTest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("학생명==>");
    String name = sc.nextLine();
    System.out.println("국어, 수학, 영어 점수를 차례로 입력하시오");
    int kor = Integer.parseInt(sc.nextLine());
    int math = Integer.parseInt(sc.nextLine());
    int eng = Integer.parseInt(sc.nextLine());
    int sum = kor + math + eng;
    double avg = (double) sum / 3;
    System.out.println("=============================");
    System.out.println("학생명: " + name);
    System.out.println("국어: " + kor + "점");
    System.out.println("수학: " + math + "점");
    System.out.println("영어: " + eng + "점");
    System.out.println("평균: " + avg + "점");
  }
}
