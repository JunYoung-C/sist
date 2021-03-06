package day0209;

public class Ex08_IntegerException {
  public static void process() {
    int[] arr = {2, 5, 7, 8};
    for (int i = 0; i <= arr.length; i++) {
      try {
        System.out.println(arr[i]);
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.println("오류메세지 1 : " + e.getMessage());
      }
    }
  }

  public static void process2() {
    String a = "12a";
    String b = "30";
    int sum = 0;

    sum = Integer.parseInt(a) + Integer.parseInt(b);
    System.out.println("두수의 합은" + sum);
  }
  public static void main(String[] args) {
    process();
    
    try {
      process2();
    }catch(NumberFormatException e) {
      System.out.println("예외처리를 메인에서 했어요: " +e.getMessage());
    }
    
    System.out.println("정상 종료");
  }
}
