package day0118;

public class WrapperTest_05 {
  public static void main(String[] args) {
    String su1 = "5";
    String su2 = "3";
    System.out.println("두수 더하기: " + (su1 + su2));

    int num1 = Integer.parseInt(su1);
    int num2 = Integer.parseInt(su2);
    System.out.println("변환 후 두수 더하기: " + (num1 + num2));
    
    System.out.println("변환 후 두수 빼기: " + (num1 - num2));
    System.out.println("변환 후 두수 곱하기: " + (num1 * num2));
    System.out.println("변환 후 두수 나누기: " + (num1 / num2));

  }
}
