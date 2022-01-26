package day0126;

import java.util.Scanner;

public class Ex08_ArraysSearch {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int[] data = {23, 66, 78, 98, 88, 46, 100, 43, 71, 29, 69};
    int len = data.length;
    
//    System.out.println("검색할 숫자 입력");
//    int n = stdIn.nextInt();
    boolean flag = false;
    int index = -1;

    
    while (true) {
      System.out.println("검색할 숫자 입력");
      int n = stdIn.nextInt();
      if (n == 0) {
        System.out.println("종료");
        break;
      }
      
      for (int i = 0; i < len; i++) {
        if (data[i] == n) {
          flag = true;
          index = i;
        }
      }
      
      if (flag) {
        System.out.println(index + "번째에 숫자가 존재합니다.");
        break;
      } else {
        System.out.println("해당 숫자가 존재하지 않습니다.");
      }
    }

  }
}
