package day0119;

import java.util.Scanner;

public class Ex09_ScanKeyBoardIn {
  public static void main(String[] args) {
    /*
     * ***이릅을 입력하세요*** 
     * 곽경태 
     * ***핸드폰 번호를 입력하세요***
     * 
     */
    Scanner sc = new Scanner(System.in);
    
    System.out.println("***이릅을 입력하세요***");
    String name = sc.nextLine();

    System.out.println("***핸드폰 번호를 입력하세요***");
    String phoneNum = sc.nextLine();

    System.out.println("***주소를 입력하세요***");
    String address = sc.nextLine();

    System.out.println("=========================");
    System.out.println("[입력결과]\n이름:" + name + "\n핸드폰:" + phoneNum + "\n주소:" + address);
  }
}
