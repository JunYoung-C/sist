package day0128;

import java.util.Scanner;

public class Ex01_ArraysLottoReview {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    System.out.println("로또 구입 금액을 입력해주세요");
    int[] result;
    int money = stdIn.nextInt();
    
    int cnt = money / 1000;
    if (cnt <= 0) {
      System.out.println("금액이 부족합니다.");
    }
    for (int i = 1; i <= cnt; i++) {
      result = new int[6];
      
      for (int j = 0; j < 6; j++) {
        result[j] = (int) (Math.random() * 45 + 1);
        
        for (int k = 0; k < j; k++) {
          if (result[j] == result[k]) {
            j--;
            break;
          }
        }
      }
      
      for (int j = 0; j < result.length; j++) {
        int min = result[j];
        int minIdx = j;
        for (int k = j + 1; k < result.length;k++) {
          if (min > result[k]) {
            min = result[k];
            minIdx = k;
          }
        }
        int tmp = result[j];
        result[j] = min;
        result[minIdx] = tmp;
      }
      
      
      System.out.printf("%3d회:", i);
      for (int j = 0; j < 6; j++) {
        System.out.printf("%5d", result[j]);
      }
      System.out.println();
    }
  }
}
