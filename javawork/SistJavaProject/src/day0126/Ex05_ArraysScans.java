package day0126;

import java.util.Scanner;

public class Ex05_ArraysScans {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int n = stdIn.nextInt();
    int[] data = new int[n];
    for (int i = 0; i < n; i++) {
      System.out.print((i + 1) + "번째 값: ");
      data[i] = stdIn.nextInt();
    }
    int sum = 0;

    
    
    for (int i = 0; i < data.length; i++) {
      sum += data[i];
      System.out.println(i + "===> " + data[i]);
    }
    System.out.println("총합계: " + sum);
  }
}
