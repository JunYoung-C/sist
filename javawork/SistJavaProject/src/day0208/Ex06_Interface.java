package day0208;

interface Color1 {
  String INITCOLOR = "white";
  public void showColor();
}

class Red1 implements Color1 {

  @Override
  public void showColor() {
    // TODO Auto-generated method stub
    System.out.println("기본 색상: " + INITCOLOR);
    System.out.println("레드로 도색할 예정입니다");
  }
  
}

class Blue1 implements Color1 {

  @Override
  public void showColor() {
    // TODO Auto-generated method stub
    System.out.println("블루로 도색중입니다.");
  }
  
}

class White implements Color1 {

  @Override
  public void showColor() {
    // TODO Auto-generated method stub
    System.out.println("다시 화이트로 돌아가려고 계획중입니다.");
  }
  
}
public class Ex06_Interface {

}
