package day0207;

class Food {
  private String name;
  private int price;
  private String bigo;
  private static int no;

  public Food(String name, int price, String bigo) {
    super();
    this.name = name;
    this.price = price;
    this.bigo = bigo;
  }

  public static void showTitle() {
    System.out.println("No.\t음식명\t가격\t비고");
    System.out.println("==============================");
  }

  public void showMenu() {
    no++;
    System.out.println(no + "\t" + name + "\t" + price + "\t" + bigo);
  }
}


public class Ex02_ArrayReview {
  public static void main(String[] args) {
    Food[] foods = new Food[4];
    Food.showTitle();
    foods[0] = new Food("막국수", 8500, "추천메뉴");
    foods[1] = new Food("감자전", 7000, "인기메뉴");
    foods[2] = new Food("메밀전", 9000, "1위메뉴");
    foods[3] = new Food("파전", 15000, "수요미식회 추천");
    
    for (int i = 0; i < foods.length; i++) {
      foods[i].showMenu();
    }
  }
}
