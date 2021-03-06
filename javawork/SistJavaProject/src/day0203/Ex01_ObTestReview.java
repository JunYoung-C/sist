package day0203;

class TestA {
  String name = "이용기";
  static String MESSAGE = "HappyDay!!";
}


public class Ex01_ObTestReview {
  int a;
  static int b;
  public static void main(String[] args) {
    // static 변수는 바로 사용 가능
    b = 20;
    System.out.println("b=" +b);
    
    // 인스턴스 변수는 인스턴스가 있어야 접근 가능
    Ex01_ObTestReview ob1 = new Ex01_ObTestReview();
    Ex01_ObTestReview ob2 = new Ex01_ObTestReview();
    
    ob1.a = 10;
    ob2.a = 30;
    
    System.out.println("ob1.a=" + ob1.a);
    System.out.println("ob2.a=" + ob2.a);
    
    TestA ta = new TestA();
    System.out.println(ta.name);
    System.out.println(TestA.MESSAGE);
  }
}
