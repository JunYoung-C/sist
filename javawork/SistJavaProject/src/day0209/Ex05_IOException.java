package day0209;

import java.io.IOException;
import java.io.InputStream;

// 문자 스트림 : Reader, Writer - 문자단위
// 바이트 스트림 : InputStream, OutputStream - 바이트 단위
// BufferReader 클래스는 readLine() - 한줄씩 읽어온다. flush라는 버퍼 내용을 스트림으로 전송하는 작업이 필요
public class Ex05_IOException {
  public static void main(String[] args) {
    InputStream is = System.in; // 콘솔에서 입력
    int a = 0;
    System.out.print("한글자 입력:");
    
    try {
      a = is.read();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      System.out.println("오류: " + e.getMessage());
    }
    
    System.out.println("3초 뒤에 출력합니다.");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    System.out.println("입력값: " + (char)a);
  }
}
