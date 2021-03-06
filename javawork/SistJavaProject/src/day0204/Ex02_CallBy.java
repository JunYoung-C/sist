package day0204;

// 기본형 데이터 타입 : int, long, char, double 등등
// 레퍼런스형 : 클래스, 배열 등

// call By Value : 값이 전달
// call By reference : 주소가 전달

public class Ex02_CallBy {
  public static void changeInt(int n) {
    System.out.println("전달받은 정수값: " + n);
  }

  public static void changeArr(int[] arr) {
    System.out.println("전달받은 배열 출력");
    for (int a : arr) {
      System.out.println(a);
    }
  }

  public static void main(String[] args) {
    changeInt(50);
    System.out.println();

    int[] arr = new int[] {10, 20, 30};
    changeArr(arr);
    
  }
}
