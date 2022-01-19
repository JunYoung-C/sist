package day0118;

public class DataType_08 {
  public static void main(String[] args) {
    //논리형 : true or false
    boolean flag = false;
    
    //문자형 : 기본적으로 정수형. 아스키코드로 변환 가능. 2바이트.
    char ch = '가';
    byte a = 127;
    int b = 32000;
    long c = 670000L;
    int num = 100;
    float f = 3.1434f;
    double d = 4356.34;
    
    System.out.printf("d=%10.2f\n", d);
    System.out.println(a);
  }
}
