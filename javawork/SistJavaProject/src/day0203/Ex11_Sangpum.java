package day0203;

class Shop {
  private String sangpum;
  private int price;
  private String color;


  public Shop(String sangpum, int price, String color) {
    this.sangpum = sangpum;
    this.price = price;
    this.color = color;
  }

  public String getSangpum() {
    return sangpum;
  }

  public void setSangpum(String sangpum) {
    this.sangpum = sangpum;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }
  
  public static void showTitle() {
    System.out.println("상품명       단가         색상");
    System.out.println("===========================");
  }
  
  public void showSangpum() {
//    System.out.println(this.sangpum + "\t\t" + this.price + "원\t\t" + this.color);
    System.out.printf("%-8s%8d원%8s\n", this.sangpum, this.price, this.color);
  }
}


public class Ex11_Sangpum {
  public static void main(String[] args) {
    Shop[] shops = new Shop[5];
    shops[0] = new Shop("아이폰13", 950000, "화이트");
    shops[1] = new Shop("갤럭시 폴드", 1200000, "핑크");
    shops[2] = new Shop("아이폰11", 750000, "블랙");
    shops[3] = new Shop("맥북", 2100000, "메탈그레이");
    shops[4] = new Shop("갤럭시북", 2200000, "그레이");
    
    Shop.showTitle();
    for (int i = 0; i < shops.length; i++) {
      shops[i].showSangpum();
    }
  }
}
