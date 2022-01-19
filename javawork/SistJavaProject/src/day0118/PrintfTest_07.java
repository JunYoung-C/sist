package day0118;

public class PrintfTest_07 {
  public static void main(String[] args) {
    int num1 = 10, num2 = 20;
    int num3 = num1 + num2;

//    System.out.printf("%s의 값은 %d, num2의 값은 %d, num3의 값은 %d입니다.", "num1", num1, num2, num3);
    
    String name = "홍길동";
    int age = 22;
    
    System.out.printf("안녕하세요. 제 이름은 %s입니다.\n나이는 %d살입니다.", name, age);
  }
}
