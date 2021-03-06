package day0119;

import java.util.Calendar;

public class Ex05_CalendarTest {
  public static void main(String[] args) {
    
    Calendar cal = Calendar.getInstance();
    
    System.out.println("지금은 " + cal.get(cal.YEAR) + "년도 입니다.");
    System.out.println("지금은 " + (cal.get(cal.MONTH) + 1) + "월 입니다.");
    System.out.println("지금은 " + cal.get(cal.DAY_OF_MONTH) + "일 입니다.");
    System.out.println("지금은 " + cal.get(cal.HOUR_OF_DAY) + "시" + cal.get(cal.MINUTE) + "분");
  }
}
