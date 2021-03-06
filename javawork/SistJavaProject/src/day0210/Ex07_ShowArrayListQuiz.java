package day0210;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Shop {
  private String sang;
  private int dan;
  private int su;

  public Shop(String sang, int dan, int su) {
    super();
    this.sang = sang;
    this.dan = dan;
    this.su = su;
  }

  public String getSang() {
    return sang;
  }

  public void setSang(String sang) {
    this.sang = sang;
  }

  public int getDan() {
    return dan;
  }

  public void setDan(int dan) {
    this.dan = dan;
  }

  public int getSu() {
    return su;
  }

  public void setSu(int su) {
    this.su = su;
  }

  public int getTotal() {
    return dan * su;
  }
}


public class Ex07_ShowArrayListQuiz {
  List<Shop> shops = new ArrayList<>();
  Scanner stdIn = new Scanner(System.in);

  void showTitle() {
    System.out.println("1.상품입고\t2.상품재고\t9.종료");
  }

  public void inputData() {

    System.out.println("상품은?");
    String sang = stdIn.nextLine();
    System.out.println("가격은?");
    int dan = Integer.parseInt(stdIn.nextLine());
    System.out.println("수량은?");
    int su = Integer.parseInt(stdIn.nextLine());

    shops.add(new Shop(sang, dan, su));

    System.out.println(shops.size() + "개의 상품을 기록했어요");
  }


  public void writeData() {
    System.out.println("No.\t상품명\t가격\t수량\t총액");
    int len = shops.size();
    for (int i = 0; i < len; i++) {
      Shop s = shops.get(i);

      System.out.println((i + 1) + "\t" + s.getSang() + "\t" + s.getDan() + "\t" + s.getSu() + "\t"
          + s.getTotal());
    }
  }

  public static void main(String[] args) {
    Ex07_ShowArrayListQuiz T = new Ex07_ShowArrayListQuiz();
    int n;


    while (true) {
      T.showTitle();
      n = Integer.parseInt(T.stdIn.nextLine());
      
      if (n == 1) {
        T.inputData();
      } else if (n == 2) {
        T.writeData();
      } else {
        System.out.println("종료합니다.");
        break;
      }
      System.out.println();
    }
  }
}
