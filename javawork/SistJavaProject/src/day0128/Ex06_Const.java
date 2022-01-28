package day0128;

class NumbConst {
  int num;

  public NumbConst() {
//    num = 10;
    System.out.println("생성자 호출");
  }

  public NumbConst(int num) {
    this.num = num;
    System.out.println("num 값을 인자로 가지고 있는 생성자 호출");
  }
  
  public int getNumber() {
    num = 50;
    return num;
  }
}


public class Ex06_Const {
  public static void main(String[] args) {
    NumbConst num1 = new NumbConst();
    NumbConst num2 = new NumbConst(30);
    NumbConst num3 = new NumbConst();
    System.out.println(num3.getNumber());
  }
}
