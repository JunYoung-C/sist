package day0209;

import java.util.Scanner;

class PayOuter {
  private String sawonName;
  private int gibonPay, timeSu, familySu;

  InputInner input = new InputInner();
  SudangInner output = new SudangInner();
  
  public void process() {
    input.inputData();
    output.writeData();
  }
  
  class InputInner {
    public void inputData() {
      Scanner stdIn = new Scanner(System.in);
      System.out.println("사원명 입력");
      sawonName = stdIn.next();
      System.out.println("기본급은?");
      gibonPay = stdIn.nextInt();
      System.out.println("초과시간은?");
      timeSu = stdIn.nextInt();
      System.out.println("기족수는?");
      familySu = stdIn.nextInt();
    }
  }


  class SudangInner {
    public int getTimeSudang() {
      return timeSu * 10000;
    }

    public int getFamilySudang() {
      if (familySu <= 3) {
        return 2000000;
      } else {
        return 3000000;
      }
    }

    public int getNetPay() {
      return gibonPay + getFamilySudang() + getTimeSudang();
    }

    public void writeData() {
      System.out.println("사원명\t기본급\t초과시간수\t가족수\t시간수당\t가족수당\t실수령액");
      System.out.println(sawonName + "\t" + gibonPay + "\t" + timeSu + "\t" + familySu + "\t"
          + getTimeSudang() + "\t" + getFamilySudang() + "\t" + getNetPay());
    }
  }
}


public class Ex02_InnerReview {
  public static void main(String[] args) {
    PayOuter pay = new PayOuter();
    pay.process();
  }
}
