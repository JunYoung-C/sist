package month01.day0118;

public class DataType_09 {
  public static void main(String[] args) {
    byte a = -127;
    byte b = (byte) 128;
    System.out.println("a=" + a);
    System.out.println("b=" + b);

    // 강제 형변환(cast 연산자) 바르게 사용

    int x = 7;
    int y = 4;

    System.out.println(x / y); // 정수형끼리의 계산은 무조건 정수형
    System.out.println((double) x / y); // double로 변환. 결과도 double
    System.out.println(x / (double) y); // 수식 중 double 있을 경우 결과도 double 타입
    
    double d = 100.0;
    int i = 100;
    int result = (int)d + i;
    double result2 = d + i;
    
    System.out.println(result);
    System.out.println(result2);
  }
}
