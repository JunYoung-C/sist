package day0119;

import java.util.Calendar;
import java.util.Scanner;

public class Ex07_ScannerCalAge {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Calendar cal = Calendar.getInstance();

    String name = sc.nextLine();
    int curYear = cal.get(cal.YEAR);

    int myYear = Integer.parseInt(sc.nextLine());

    int myAge = curYear - myYear + 1;

    System.out.println("현재 년도: " + curYear);
    System.out.println("당신의 이름은? " + name);
    System.out.println("태어난 년도는? " + myYear);
    System.out.println("---------------------------");
    System.out.println(name + "님은 " + myYear + "년 생이며 " + myAge + "세 입니다.");
  }
}
