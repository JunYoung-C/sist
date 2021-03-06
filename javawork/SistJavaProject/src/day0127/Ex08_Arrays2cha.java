package day0127;

public class Ex08_Arrays2cha {
  public static void main(String[] args) {
    int[][] arr;
    arr = new int[2][3];
    arr[0][0] = 10;
    arr[0][1] = 20;
    arr[0][2] = 30;
    
    arr[1][0] = 5;
    arr[1][1] = 15;
    arr[1][2] = 25;
    
    System.out.println("2차원 배열 데이터 출력");
    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < arr[0].length; j++) {
        System.out.printf("[%d, %d] = %2d\t", i, j, arr[i][j]);
      }
      System.out.println();
    }
  }
}
