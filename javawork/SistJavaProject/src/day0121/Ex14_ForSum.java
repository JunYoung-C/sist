package day0121;

public class Ex14_ForSum {
  public static void main(String[] args) {
    int sum = 0;
    for (int i = 1; i <= 5; i++) {
      sum += i;
    }
    
    int i = 1;
    sum = 0;
    while (i <= 10) {
      if (i % 2 == 1) {
        sum += i;
      }
      i++;
    }
    
    System.out.println("1부터 10까지의 홀수의 합은 " + sum + "입니다.");
  }
  
}
