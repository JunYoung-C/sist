package day0209;

import java.util.Random;
import java.util.Scanner;

public class Ex09_Exception {

  public static void process() {
    Scanner stdIn = new Scanner(System.in);
    int su1, su2;
    
    System.out.println("두수를 입력하세요");
    su1 = stdIn.nextInt();
    su2 = stdIn.nextInt();
    try {
      System.out.println("su1/su2=" + su1/su2);
    } catch (ArithmeticException e) {
      System.out.println("0으로 나누면 안돼요 : " + e.getMessage());
    }
  }

  public static void process2() throws NullPointerException {
//    int rnd = (int) (Math.random() * 10) + 1;
    Random r = null;
    int rnd = r.nextInt(10);
    System.out.println("발생한 난수는 " + rnd + "입니다.");
  }
  public static void main(String[] args) {
    process();
    process2();
  }
}
