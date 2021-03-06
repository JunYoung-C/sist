package day0210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex11_FileBufferToken {

  public static void fileRead() {
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\info1.txt";
    FileReader fr = null;
    BufferedReader br = null;
    try {
      fr = new FileReader(fileName);
      br = new BufferedReader(fr);

      System.out.println("파일 읽기 결과");
      System.out.println("이름\t학교명\t학년");

      while (true) {
        String s = br.readLine();

        if (s == null) {
          break;
        }
        
        String[] arr = s.split(",");
        System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2]);
        
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }finally {
      
      try {
        br.close();
        fr.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    fileRead();
  }
}
