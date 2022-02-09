package day0209;

public class ArrayException {
  public static void main(String[] args) {
    String[] str = {"apple", "Orange", "kiwi", "banana"};
    
    System.out.println("차례대로 출력");
    
    for (int i = 0; i <= str.length; i++) {
      
      try {
        System.out.println(str[i]);        
      }catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }
    
    for (int i = str.length; i >= 0; i--) {
      try {
        System.out.println(str[i]);        
      }catch(Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
