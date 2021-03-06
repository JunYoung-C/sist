package day0121;

import java.util.Scanner;

public class Ex06_SwitchScore {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    int score;
    String grade;
    System.out.println("당신의 점수는?");
    score = stdIn.nextInt();

    System.out.println("당신의 점수는 " + score + "점 입니다.");
    switch (score / 10) {
      case 10:
      case 9:
        grade = "A";
        break;
      case 8:
        grade = "B";
        break;
      case 7:
        grade = "C";
        break;
      case 6:
        grade = "D";
        break;
      default:
        grade = "F";
        break;
    }

    System.out.println("학점은 " + grade + "입니다.");
    String result;
    result = (score >= 90) ? "합격입니다." : (score >= 80) ? "좀 더 노력하세요" : "다음 기회에...";
    System.out.println(result);
  }
}
