package day0125;

public class Ex03_MathRandom {
  public static void main(String[] args) {
    
    System.out.println("0부터 99 사이의 난수 발생");
    for (int i = 1; i <= 10; i++) {
      int n = (int)(Math.random() * 100);
      System.out.println(n);
      
    }
    System.out.println("----------------------------");
    System.out.println("1부터 45 사이의 난수 발생");
    for (int i = 1; i <= 10; i++) {
      int n = (int)(Math.random() * 45) + 1;
      System.out.println(n);
      
    }
    
    System.out.println("----------------------------");
    System.out.println("65부터 90 사이의 난수 발생");
    for (int i = 1; i <= 10; i++) {
      int n = (int)(Math.random() * 26) + 65;
      System.out.println(n);
      
    }
  }
}
