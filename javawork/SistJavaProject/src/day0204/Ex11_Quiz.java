package day0204;

import java.util.Scanner;

class Member {
  private static String empName;
  private String name;
  private int basicPay;
  private int extraPay;

  public Member(String name, int basicPay, int extraPay) {
    this.name = name;
    this.basicPay = basicPay;
    this.extraPay = extraPay;
  }

  
  public static String getEmpName() {
    return empName;
  }


  public static void setEmpName(String empName) {
    Member.empName = empName;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBasicPay() {
    return basicPay;
  }

  public void setBasicPay(int basicPay) {
    this.basicPay = basicPay;
  }

  public int getExtraPay() {
    return extraPay;
  }

  public void setExtraPay(int extraPay) {
    this.extraPay = extraPay;
  }

  public static void showTitle() {
    System.out.println("회사명: " + empName);
    System.out.println("사원명\t기본급\t수당\t총급여");
    System.out.println("============================");
  }

  public int getTotalMoney() {
    return basicPay + extraPay;
  }
}


public class Ex11_Quiz {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.print("회사명 : ");
    Member.setEmpName(stdIn.next());
    System.out.print("사원수 : ");
    int n = stdIn.nextInt();

    Member[] members = new Member[n];

    for (int i = 0; i < n; i++) {
      System.out.println((i + 1) + "번째 사원 정보");
      System.out.print("사원명 : ");
      String name = stdIn.next();
      System.out.print("기본급 : ");
      int pay = stdIn.nextInt();
      System.out.print("수당 : ");
      int extra = stdIn.nextInt();
      members[i] = new Member(name, pay, extra);
    }

    Member.showTitle();

    for (int i = 0; i < n; i++) {
      Member m = members[i];
      System.out.println(
          m.getName() + "\t" + m.getBasicPay() + "\t" + m.getExtraPay() + "\t" + m.getTotalMoney());
    }
  }
}
