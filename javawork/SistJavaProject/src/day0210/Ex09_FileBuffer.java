package day0210;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// score.txt를 읽고 총 몇개인지 구하고
public class Ex09_FileBuffer {
  
  public static void scoreRead() throws IOException, FileNotFoundException {
    String fileName = "C:\\sist\\javawork\\SistJavaProject\\score.txt";
    FileReader fr = new FileReader(fileName);
    BufferedReader br = new BufferedReader(fr);
    int cnt = 0;
    int total = 0;
    double avg = 0;
    
    while (true) {
      String s = br.readLine();
      if (s == null) {
        break;
      }
      
      cnt++;
      total += Integer.parseInt(s);
    }
    
    avg = (double) total / cnt;

    System.out.println("총개수: " + cnt);
    System.out.println("총점: " + total);
    System.out.printf("평균: %.2f", avg);
    
    br.close();
    fr.close();
  }
  public static void main(String[] args) {
    try {
      scoreRead();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    
  }
}
