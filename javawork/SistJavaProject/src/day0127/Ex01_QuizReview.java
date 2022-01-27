package day0127;

import java.util.Scanner;

public class Ex01_QuizReview {
  public static void main(String[] args) {
    // 스캐너로 숫자를 입력받아서 배열에 몇번째 있는지 출력
    // 없을 경우 없다고 출력. 0을 입력시 종료
    Scanner stdIn = new Scanner(System.in);
    
    int[] arr = {6, 11, 45, 66, 78, 23, 88, 77, 100};
    int n, idx = 0;
    int cnt =0;

    
    while (true) {
      cnt++;
      System.out.print("입력값" + cnt + ": ");
      n = stdIn.nextInt();
      
      boolean flag = false;
      
      if (n == 0) {
        System.out.println("\t종료합니다.");
        break;
      }
      
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == n) {
          idx = i;
          flag = true;
          break;
        }
      }
      
      if (flag) {
        System.out.println("\t" + n + "은 " + (idx + 1) + "번째에 있어요!!");
      } else {
        System.out.println("\t" + n + "은 없어요!!");
      }
    }
  }
}
