package day0120;

public class Ex02_OperTest {
  public static void main(String[] args) {
    int a, b;
    a = b = 5;
    
    // 단항일 경우에는 앞에 붙이나 뒤에 붙이나 같다.
    ++a;
    b++;
    
    System.out.println("a=" + a + ", b=" + b);
    
    int m, n;
    a = b = 5;
    
    m = a++;
    n = ++b;
    System.out.println("m=" + m + ", n=" + n);

  }
} 


