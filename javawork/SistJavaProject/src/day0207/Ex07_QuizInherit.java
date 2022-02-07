package day0207;

class Shop {
  private String sangpum;
  private int su;

  public Shop(String sangpum, int su) {
    super();
    this.sangpum = sangpum;
    this.su = su;
  }

  public void writeShop() {
    System.out.println("상품명:" + sangpum);
    System.out.println("수량:" + su + "개");
  }
}


class MyShop extends Shop {

  private int price;

  public MyShop(String sangpum, int su, int price) {
    super(sangpum, su);
    this.price = price;
  }

  @Override
  public void writeShop() {
    // TODO Auto-generated method stub
    System.out.println("단가:" + price + "원");
    super.writeShop();
    System.out.println();
  }
}


public class Ex07_QuizInherit {
  public static void main(String[] args) {
    MyShop myshop1 = new MyShop("딸기", 5, 1000);
    MyShop myshop2 = new MyShop("오렌지", 4, 1200);
    myshop1.writeShop();
    myshop2.writeShop();
  }
}
