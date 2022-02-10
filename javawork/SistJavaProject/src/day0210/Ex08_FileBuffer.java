package day0210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex08_FileBuffer {
  public static void read() {
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\memo1.txt";
    BufferedReader br = null;
    FileReader fr = null;


    try {
      fr = new FileReader(fileName);
      br = new BufferedReader(fr);
      while (true) {
        String s = br.readLine();
        if (s == null) {
          break;
        }

        System.out.println(s);
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("파일이 없어요: " + e.getMessage());
    } catch (IOException e) {

    } finally {
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
    read();
    System.out.println("정상 종료");
  }
}
