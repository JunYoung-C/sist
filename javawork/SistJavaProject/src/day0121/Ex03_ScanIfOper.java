package day0121;

import java.util.Scanner;

public class Ex03_ScanIfOper {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    
    
    System.out.println("상품명?");
    String name = stdIn.nextLine();
    System.out.println("수량?");
    int amount = stdIn.nextInt();
    System.out.println("단가?");
    int price = stdIn.nextInt();

    int total = amount * price;
    System.out.println(name + " " + amount + "개는 총" + total + "원 입니다.");
    if (amount >= 5) {
      total *= 0.9;
//      total = total * 0.9;
      System.out.println("수령이 5개 이상이면 10프로 DC");
      System.out.println("dc된 총 금액: " + total);
    }
    
  }
}
