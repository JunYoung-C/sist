package day0126;

public class Ex02_Arrays {
  public static void main(String[] args) {
    //배열선언
    //기본형 배열은 객체로 인식
    //int[] arr = new int[3];
    //int arr[] = new int[3];
    // 선언과 동시에 초기값을 주기도 한다.
    
    int[] arr, arr2;
    arr = new int[3];
    arr2 = new int[5];
    
    //배열에 값 넣기
    arr[0] = 10;
    arr[1] = 5;
    arr[2] = 20;
    
    System.out.println("arr 배열의 갯수: " + arr.length);
    
    //출력시 반복문을 이용해서 일괄적으로 출력
    System.out.println("for문으로 일괄 출력");
    for (int i = 0; i < 3; i++) {
      System.out.println(arr[i]);
    }
    
    System.out.println("향상된 for문으로 일괄 출력");
    for (int i : arr) {
      System.out.println(i);
    }
    
    System.out.println("arr2값 출력");
    System.out.println("for문으로 일괄 출력_arr2");
    for (int i = 0; i < arr2.length; i++) {
      System.out.println(arr2[i]);
    }
    System.out.println("for~each문으로 일괄 출력_arr2");
    for (int i : arr2) {
      System.out.println(i);
    }
    
    
  }
}
