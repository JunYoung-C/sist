package day0126;

public class Ex04_Arrays {
  public static void main(String[] args) {
    int[] arr = {5, 7, 84, 88, 9, 43, 6, 88};
    System.out.println("개수 : " + arr.length);
    System.out.println("#1");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    System.out.println("#2");
    for (int i : arr) {
      System.out.print(i + " ");
    }

    System.out.println();
    System.out.println("==========================");
    // 방법 1
    int[] arr1 = new int[5];
    arr1[1] = 10;
    arr1[4] = 34;
    for (int n : arr1) {
      System.out.println(n);
    }

    // 방법 2
    int[] arr2 = {44, 77, 88, 99, 100};
    System.out.println("----------------------------");
    System.out.println(arr2.length);
    System.out.println("----------------------------");
    for (int i = 4; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }
    System.out.println("----------------------------");
    for (int n : arr2) {
      System.out.printf("%5d", n);
    }

    // 문자열 배열
    String[] str1 = new String[5];
    // str1에 무자열 넣기
    str1[0] = "장미";
    str1[2] = "후리지아";
    
    String[] str2 = {"레드", "노랑", "그린", "파랑"};
    System.out.println();
    
    for (int i = 0; i < str1.length; i++) {
      System.out.print(str1[i] + " ");
    }
    System.out.println();
    for (String i : str1) {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < str2.length; i++) {
      System.out.print(str2[i] + " ");
    }
    System.out.println();

    for (String i : str2) {
      System.out.print(i + " ");
    }
    System.out.println();

  }
}
