package day0204;

import java.util.Scanner;

class Emp {
  private String name;
  private int pay;
  private int famsu;
  private int timesu;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPay() {
    return pay;
  }

  public void setPay(int pay) {
    this.pay = pay;
  }

  public int getFamsu() {
    return famsu;
  }

  public void setFamsu(int famsu) {
    this.famsu = famsu;
  }

  public int getTimesu() {
    return timesu;
  }

  public void setTimesu(int timesu) {
    this.timesu = timesu;
  }

  public int getTimeSudang() {
    int n = 0;
    if (timesu >= 5) {
      n = 150000;
    } else {
      n = timesu * 30000;
    }
    return n;
  }

  public int getFamilySudang() {
    int n = 0;
    if (famsu >= 4) {
      n = 200000;
    } else {
      n = famsu * 50000;
    }
    return n;
  }

  public int getTotalPay() {
    int tp = pay + getFamilySudang() + getTimeSudang();
    return tp;
  }

  public static void showTitle() {
    System.out.println("[쌍용전자 직원 급여현황");
    System.out.println();
    System.out.println("사원명\t급여\t가족수\t초과시간\t가족수당\t시간수당\t총급여");
    System.out.println("-----------------------------------------");
  }
}


public class Ex10_ScanArraynewSalary {
  public static void writeEmp(Emp[] emp) {
    Emp.showTitle();
    for (Emp e : emp) {
      System.out
          .println(e.getName() + "\t" + e.getPay() + "\t" + e.getFamsu() + "\t" + e.getTimesu()
              + "\t" + e.getFamilySudang() + "\t" + e.getTimeSudang() + "\t" + e.getTotalPay());
    }
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    int inwon;
    Emp[] emp;
    
    System.out.println("입력할 직원수는?");
    inwon = stdIn.nextInt();
    
    emp = new Emp[inwon];
    for (int i = 0; i < inwon; i++) {
      System.out.println("이름은?");
      String name = stdIn.next();
      System.out.println("급여는?");
      int pay = stdIn.nextInt();
      System.out.println("가족수는?");
      int fs = stdIn.nextInt();
      System.out.println("초과근무시간은?");
      int ts = stdIn.nextInt();
      
      emp[i].setName(name);
      emp[i].setPay(pay);
      emp[i].setFamsu(fs);
      emp[i].setTimesu(ts);
    }

    writeEmp(emp);
    
    
  }
}
