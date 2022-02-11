package day0211;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Ex01_Format {
  public static void main(String[] args) {
    Date date = new Date();
    System.out.println(date);
    
    // 날짜, 시간을 원하는 형식으로 출력
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    System.out.println(sdf1.format(date));
    
    // a : 오전/오후
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
    System.out.println(sdf2.format(date));
    
    // EEE: 요일 짧게, EEEE: 요일 길게
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss EEEE");
    System.out.println(sdf3.format(date));
    
    int money = 674500;
    double num = 45.3456;
    
    NumberFormat nf1 = NumberFormat.getCurrencyInstance(Locale.KOREA);
    System.out.println(nf1.format(money));
    
    NumberFormat nf2 = NumberFormat.getInstance();
    System.out.println(nf2.format(money));
    System.out.println(nf2.format(num));
    
  }
}
