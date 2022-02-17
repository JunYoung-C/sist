package day0217;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex07_SerialShop {
  ArrayList<Ex07_Shop> shops = new ArrayList<>();
  Scanner stdIn = new Scanner(System.in);
  
  public void addShop() {
    System.out.println("상품명은?");
    String name = stdIn.nextLine();
    System.out.println("수량은?");
    int amount = Integer.parseInt(stdIn.nextLine());
    System.out.println("단가는?");
    int price = Integer.parseInt(stdIn.nextLine());
    
    Ex07_Shop shop = new Ex07_Shop(name, amount, price);
    shops.add(shop);
    System.out.println(shops.size() + "번째 상품이 추가되었습니다.");
  }
  
  public void writeFile() {
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    
    try {
      fos = new FileOutputStream("C:\\sist\\javawork\\SistJavaProject\\shop0217.txt");
      oos = new ObjectOutputStream(fos);
      
      oos.writeObject(shops);
      System.out.println("파일에 list 전체를 저장하였습니다.");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        oos.close();
        fos.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public void process() {
    while (true) {
      System.out.println("1. shop 정보 추가 2. 전체 목록 파일에 저장 3. 종료");
      int n = Integer.parseInt(stdIn.nextLine());
      
      switch (n) {
        case 1:
          addShop();
          break;
        case 2:
          this.writeFile();
          break;
        default:
          System.out.println("시스템을 종료합니다.");
          System.exit(0);
      }
    }
  }
  public static void main(String[] args) {
    Ex07_SerialShop ex = new Ex07_SerialShop();
    ex.process();
  }
}
