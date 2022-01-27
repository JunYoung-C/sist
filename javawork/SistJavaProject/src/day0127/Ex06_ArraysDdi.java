package day0127;

import java.util.Scanner;

public class Ex06_ArraysDdi {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    String[] ddi = {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
    int len = ddi.length;

    System.out.println("이름 입력");
    String name = stdIn.next();
    System.out.println("태어난 연도 입력");
    int year = stdIn.nextInt();
    System.out.println(name + "님은 " + ddi[year % len] + "띠 입니다.");
  }
}
