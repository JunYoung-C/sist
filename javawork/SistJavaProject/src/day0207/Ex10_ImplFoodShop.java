package day0207;

// 클래스가 클래스를 extends
// 클래스가 인터페이스를 implements
// 인터페이스가 인터페이스를 extends

class FoodA implements Ex10_FoodShop {
  @Override
  public void order() {
    // TODO Auto-generated method stub
    System.out.println(SHOPNAME);
    System.out.println("음식을 주문합니다.");
  }

  @Override
  public void beadal() {
    // TODO Auto-generated method stub
    System.out.println(SHOPNAME);
    System.out.println("음식을 배달합니다.");
  }
}


public class Ex10_ImplFoodShop {

  public static void main(String[] args) {
    FoodA fa = new FoodA();
    fa.order();
    fa.beadal();
    System.out.println("---------------------");

    Ex10_FoodShop fs = new FoodA();
    fs.order();
    fs.beadal();
  }

}
