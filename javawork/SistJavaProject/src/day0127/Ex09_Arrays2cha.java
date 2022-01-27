package day0127;

public class Ex09_Arrays2cha {
  public static void main(String[] args) {
    int[][] arr = {{23, 44}, {11, 22, 33}, {10, 20, 30, 40}};
    
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        System.out.printf("[%d, %d] = %2d\t", i, j, arr[i][j]);
      }
      System.out.println();
    }
  }
}
