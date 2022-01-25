package day0124;

public class Ex03_WhileTrueCnt {
  public static void main(String[] args) {
    // 1 ~ 100까지의 숫자 중에서 3의 배수는 총 몇개가 있는지 개수를 구하시오
    
    int cnt = 0;
//    for (int i = 1; i <= 100; i++) {
//      if (i % 3 == 0) {
//        cnt++;
//      }
//    }
    
    int n = 0;
    while (true) {
      n++;
      if (n % 3 == 0) {
        cnt++;
      }
      
      if (n >= 100) {
        break;
      }
    }
    
    System.out.println("3의 배수 갯수 : " + cnt + "개");
  }
}
