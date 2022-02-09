package day0209;

public class Ex04_Exception {
  public static void main(String[] args) {
    int[] arr = {4, 6, 6};
    
    for (int i = 0; i < arr.length; i++) {
      try {
        System.out.println(arr[i]);
        
      } catch(Exception e) {
        System.out.println("오류 메세지: " + e.getMessage());
      }
    }
  }
}
