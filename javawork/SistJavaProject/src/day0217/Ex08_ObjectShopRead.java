package day0217;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Ex08_ObjectShopRead {
  ArrayList<Ex07_Shop> shops = new ArrayList<Ex07_Shop>();

  void readFile() {
    FileInputStream fi = null;
    ObjectInputStream oi = null;
    try {
      fi = new FileInputStream("C:\\sist\\javawork\\SistJavaProject\\shop0217.txt");
      oi = new ObjectInputStream(fi);

      shops = (ArrayList<Ex07_Shop>) oi.readObject();

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Ex08_ObjectShopRead ex = new Ex08_ObjectShopRead();
    ex.readFile();

    System.out.println("상품명\t수량\t단가");
    System.out.println("--------------------");
    for (Ex07_Shop s : ex.shops) {
      System.out.println(s.getProductName() + "\t" + s.getAmount() + "\t" + s.getPrice());
    }
  }
}
