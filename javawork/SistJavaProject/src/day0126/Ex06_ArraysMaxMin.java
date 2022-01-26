package day0126;

public class Ex06_ArraysMaxMin {
  public static void main(String[] args) {
    int[] data = {5, 12, 66, 88, 98, 100, 35, 67, 54, 18};
    System.out.println("data 개수: " + data.length);

    int max = data[0];
    int min = data[0];
    int len = data.length;
    for (int i = 1; i < len; i++) {
      if (max < data[i]) {
        max = data[i];
      }
      if (min > data[i]) {
        min = data[i];
      }
    }
    System.out.println("최대값: " + max);
    System.out.println("최소값: " + min);
  }
}
