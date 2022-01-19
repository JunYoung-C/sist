package day0119;

public class Ex01_CastArgsTest {
  public static void main(String[] args) {
    
    String name = "홍길동";
    String age = "22";
    
    
    System.out.println("이름: " + name);
    System.out.println("나이: " + age);
    
    //숫자를 파라메터로 보내도 문자열로 읽으므로 계산을 위해서는 정수로 변환
    //1. 변수 선언
    int num1 = Integer.parseInt(args[0]);
    int num2 = Integer.parseInt(args[1]);
    
    //2. 계산
    int sum = num1 + num2;
    int sub = num1 - num2;
    int mul = num1 * num2;
    double div = (double) num1 / num2;
    
    //3. 출력
    System.out.println("두수의 합: " + sum);
    System.out.println("두수의 차: " + sub);
    System.out.println("두수의 곱: " + mul);
    System.out.println("두수의 나누기: " + div);
  }
}
