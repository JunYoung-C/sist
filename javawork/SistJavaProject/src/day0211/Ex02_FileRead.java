package day0211;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Member {
  private String name;
  private int pay;
  private int familyCnt;
  private int overTime;

  public Member(String name, int pay, int familyCnt, int overTime) {
    super();
    this.name = name;
    this.pay = pay;
    this.familyCnt = familyCnt;
    this.overTime = overTime;
  }

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

  public int getFamilyCnt() {
    return familyCnt;
  }

  public void setFamilyCnt(int familyCnt) {
    this.familyCnt = familyCnt;
  }

  public int getOverTime() {
    return overTime;
  }

  public void setOverTime(int overTime) {
    this.overTime = overTime;
  }

  public int getFamilyPay() {
    return familyCnt * 30000;
  }

  public int getTimePay() {
    return overTime * 20000;
  }
  
  public int getTotalPay() {
    return pay + getFamilyPay() + getTimePay();
  }
}


public class Ex02_FileRead {
  static List<Member> members = new ArrayList<Member>();

  static void read() throws IOException {
    String fileName = "C:\\\\sist\\\\javawork\\\\SistJavaProject\\\\info3.txt";
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    StringTokenizer st;
    String s;
    while (true) {
      s = br.readLine();
      if (s == null) {
        break;
      }

      st = new StringTokenizer(s, ",");
      String name = st.nextToken();
      int pay = Integer.parseInt(st.nextToken());
      int familyCnt = Integer.parseInt(st.nextToken());
      int overTime = Integer.parseInt(st.nextToken());

      members.add(new Member(name, pay, familyCnt, overTime));
    }
  }

  static void write() {
    System.out.println("***사원급여***");
    System.out.println("번호\t사원명\t기본급\t가족수\t초과근무\t가족수당\t시간수당\t총급여");
    for (int i = 0; i < members.size(); i++) {
      Member m = members.get(i);
      System.out.println((i + 1) + "\t" + m.getName()+ "\t" + m.getPay()+ "\t" + m.getFamilyCnt()+ "\t" + m.getOverTime()+ "\t" + m.getFamilyPay()+ "\t" + m.getTimePay()+ "\t" + m.getTotalPay());
    }
  }
  public static void main(String[] args) {
    try {
      read();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    write();
  }
}
