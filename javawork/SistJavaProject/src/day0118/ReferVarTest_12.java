package day0118;

public class ReferVarTest_12 {
  public static void main(String[] args) {
    char a = 'A';
    char b = '가';
    String str = "Hello";
    String str2 = new String("Happy Day");
    String str3 = new String("Hello");
    String str4 = "Hello";
    System.out.println(str == str4);
  }
}
