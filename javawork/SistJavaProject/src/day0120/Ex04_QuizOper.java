package day0120;

import java.util.Scanner;

public class Ex04_QuizOper {
  public static void main(String[] args) {
    int[] cnt = new int[5]; 
    Scanner stdIn = new Scanner(System.in);
    
    System.out.println("월 급여를 입력하여 만원, 천원, 백원, 십원, 일원의 개수를 구하시오");
    int money = stdIn.nextInt();
    
//    cnt[0] = money % 10;
//    money /= 10;
//    cnt[1] = money % 10;
//    money /= 10;
//    cnt[2] = money % 10;
//    money /= 10;
//    cnt[3] = money % 10;
//    money /= 10;
//    cnt[4] = money;
    
    cnt[0] = money / 10000;
    money %= 10000;
    cnt[1] = money / 1000;
    money %= 1000;
    cnt[2] = money / 100;
    money %= 100;
    cnt[3] = money / 10;
    money %= 10;
    cnt[4] = money;
    System.out.println("만원: " + cnt[0]);
    System.out.println("천원: " + cnt[1]);
    System.out.println("백원: " + cnt[2]);
    System.out.println("십원: " + cnt[3]);
    System.out.println("일원: " + cnt[4]);

    
  }
}
