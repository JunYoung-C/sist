package day0120;

import java.util.Calendar;
import java.util.Scanner;

public class Ex01_ScanReview {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    Calendar cal = Calendar.getInstance();
    
    System.out.print("이름 입력 : ");
    String name = stdIn.nextLine();
    System.out.print("키 입력 : ");
//    double height = Double.parseDouble(stdIn.nextLine());
    Double height =stdIn.nextDouble();
    
    System.out.print("몸무게 입력 : ");
    double weight = Double.parseDouble(stdIn.nextLine());
//    double weight =stdIn.nextDouble();

    
    
    double stWeight = (height - 100) * 0.9;
    
    System.out.println("[입력 정보]");
    System.out.println("이름 : " + name);
    System.out.printf("키&몸무게 : %.1fcm/%.1fkg\n", height, weight);
    System.out.printf("표준 몸무게 : %.2fkg\n", stWeight);
  }
}
