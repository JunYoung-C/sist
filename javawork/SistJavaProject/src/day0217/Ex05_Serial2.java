package day0217;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ex05_Serial2 {
  public static void main(String[] args) {
    FileInputStream fi = null;
    ObjectInputStream oi = null;

    try {
      fi = new FileInputStream("C:\\sist\\javawork\\SistJavaProject\\apple.txt");
      oi = new ObjectInputStream(fi);
      
      Apple a = (Apple) oi.readObject();
      System.out.println("파일에서 apple 데이터");
      a.write();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        oi.close();
        fi.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
