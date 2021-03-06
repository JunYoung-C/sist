package day0210;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Ex12_FileToken {
  public static void read() throws IOException {
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\info2.txt";
    FileReader fr = null;
    BufferedReader br = null;

    fr = new FileReader(fileName);
    br = new BufferedReader(fr);

    while (true) {
      String s = br.readLine();

      if (s == null) {
        break;
      }

      String[] products = s.split(",");
      System.out.println(products[0] + "\t" + products[1] + "\t" + products[2]);
    }
  }

  public static void main(String[] args) {
    System.out.println("***입고 물품 현황***");
    System.out.println("상품명\t수량\t단가");
    System.out.println("-------------------------");
    try {
      read();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
