package day0119;

import java.util.Calendar;

public class Ex06_CalAge {
  public static void main(String[] args) {
    String name = args[0];

    Calendar cal = Calendar.getInstance();
    int curYear = cal.get(cal.YEAR);

    int myYear = Integer.parseInt(args[1]);

    int myAge = curYear - myYear + 1;

    System.out.println("이름: " + name);
    System.out.println("태어난 년도: " + myYear + "년생");
    System.out.println("나이: " + myAge + "세");
  }
}
