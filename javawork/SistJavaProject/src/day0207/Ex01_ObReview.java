package day0207;

class Menu {
  private String name;
  private int price;
  private int no;
  
  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public Menu() {
    no++;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }
}


public class Ex01_ObReview {
  public static void main(String[] args) {
    Menu[] menus = new Menu[3];
    menus[0] = new Menu();
    menus[0].setName("피자");
    menus[0].setPrice(15000);
    menus[0].setNo(1);
    menus[1] = new Menu();
    menus[1].setName("스파게티");
    menus[1].setPrice(12000);
    menus[1].setNo(2);
    menus[2] = new Menu();
    menus[2].setName("햄버거");
    menus[2].setPrice(8000);
    menus[2].setNo(3);
    
    for (int i = 0; i < menus.length; i++) {
      Menu m = menus[i];
      System.out.println("[메뉴" + m.getNo() + "]");
      System.out.println("메뉴명:" + m.getName());
      System.out.println("가격:" + m.getPrice());
      System.out.println("------------------");
    }
  }
}
