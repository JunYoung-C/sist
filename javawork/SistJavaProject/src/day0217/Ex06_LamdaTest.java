package day0217;

// 람다 표현식은 인터페이스를 사용하는 익명내부클래스의 다른 표현식
// 단 하나의 추상메서드만 가지고 있는 경우만 가능
interface Orange {
  public void write();
}


public class Ex06_LamdaTest {

  // 익명 내부 클래스
  public void abstMethod1() {
    Orange or = new Orange() {

      @Override
      public void write() {
        // TODO Auto-generated method stub
        System.out.println("나는 익명 내부 오렌지 입니다.");
      }
    };
    or.write();
  }

  public void abstMethod2() {
    Orange or = () -> System.out.println("나는 람다의 오렌지");
    or.write();

  }

  public static void main(String[] args) {
    Ex06_LamdaTest ex = new Ex06_LamdaTest();
    ex.abstMethod1();
    System.out.println("------------------");
    ex.abstMethod2();
  }
}
