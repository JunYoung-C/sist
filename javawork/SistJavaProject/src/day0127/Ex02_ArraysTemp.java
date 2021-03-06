package day0127;

public class Ex02_ArraysTemp {
  public static void main(String[] args) {
    int a = 10, b = 20;
    
    System.out.println("a=" + a + ", b=" + b);
    
    int tmp = a;
    a = b;
    b = tmp;
    
    System.out.println("a=" + a + ", b=" + b);
    
    int[] arr = {6, 9, 3};
    for (int n : arr) {
      System.out.println(n);
    }
    
    System.out.println("0번과 2번 교환 후 출력");
    tmp = arr[0];
    arr[0] = arr[2];
    arr[2] = tmp;
    
    for (int n : arr) {
      System.out.println(n);
    }
  }
}

