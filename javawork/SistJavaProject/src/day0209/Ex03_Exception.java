package day0209;

// RunTimeException : 컴파일할때는 문제가 없지만 실행시 문제 발생
// NullPointException : 생성하지 않고 메서드 호출. 객체 참조가 없는 상태
// Numberformat : 입력데이터 형식 오류
// ArrayIndexOutOfBounce : 무자열의 인덱스 오류. 범위르 초과했을 때

public class Ex03_Exception {
  public static void main(String[] args) {
    System.out.println("프로그램 시작");
    
    try {
      int num = 3 / 0;
    } catch (ArithmeticException e) {
      System.out.println(e.getMessage());
    }
    System.out.println();
  }
}
