package day0127;

import java.util.Arrays;

public class Ex03_ArraysTemp {
  public static void main(String[] args) {
    // 거꾸로 데이터를 바꾸어 출력
    int[] arr = {5, 7, 3, 9, 12, 45, 76, 89, 10};

    // 출력
    System.out.println("원 데이터");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    // 오름차순 정렬(중첩 for)
    for (int i = 0; i < arr.length - 1; i++) {
      int min = arr[i];
      int idx = i;

      for (int j = i + 1; j < arr.length; j++) {
        if (min > arr[j]) {
          min = arr[j];
          idx = j;
        }
      }

      int tmp = arr[i];
      arr[i] = arr[idx];
      arr[idx] = tmp;
    }
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    
    Arrays.sort(arr);
    System.out.println(arr.toString());
    System.out.println(Arrays.toString(arr));
  }
}
