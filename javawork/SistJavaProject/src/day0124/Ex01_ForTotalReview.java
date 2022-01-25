package day0124;

public class Ex01_ForTotalReview {
  public static void main(String[] args) {
    // 1부터 100까지 합계 구하기
    int total = 0;
    for (int n = 1; n <= 100; n++) {
      total += n;
    }
    System.out.println(total);
    
    // 지역변수를 벗어난 곳에서 출력을 하고자 할때의 범위
    // 1부터 10까지의 합
    
    int sum = 0;
    int i = 0;
    for (; i <= 10; i++) {
      sum += i;
    }
    System.out.println((i - 1) + "까지의 합: " + sum);
  }
}
