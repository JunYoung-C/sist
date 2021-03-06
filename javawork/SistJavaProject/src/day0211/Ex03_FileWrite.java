package day0211;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex03_FileWrite {
  public static void fileWrite() {
    FileWriter fw = null;
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\test1.txt";
    
    try {
      fw = new FileWriter(fileName);
      
      fw.write("Have a nice Day!\n");
      fw.write(new Date().toString());
      
      System.out.println("파일 저장 성공");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  
  public static void fileWrite2() {
    FileWriter fw = null;
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\test2.txt";
    
    try {
      fw = new FileWriter(fileName, true);
      
      fw.write("내 이름은 최준영!\n");
      fw.write("-----------------------\n");
      System.out.println("파일 저장 성공");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  public static void main(String[] args) {
    fileWrite2();
  }
}
