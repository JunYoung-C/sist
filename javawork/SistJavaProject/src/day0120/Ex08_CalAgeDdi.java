package day0120;

import java.util.Calendar;
import java.util.Scanner;

public class Ex08_CalAgeDdi {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    Calendar cal = Calendar.getInstance();

    int myYear, age;
    String name, ddi;
    String[] twlv = new String[] {"원숭이", "닭", "개", "돼지", "쥐", "소", "호랑이", "토끼", "용", "뱀", "말", "양"};
    int curYear = cal.get(cal.YEAR);

    System.out.println("이름 입력: ");
    name = stdIn.nextLine();
    System.out.println("태어난 연도 입력: ");
    myYear = stdIn.nextInt();

    age = curYear - myYear + 1;
    ddi = twlv[myYear % 12];
    System.out.println(ddi);

  }
}
