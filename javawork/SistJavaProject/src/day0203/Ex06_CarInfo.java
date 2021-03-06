package day0203;

class MyCar {
  private String carName;
  private int price;
  private String carColor;

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getCarColor() {
    return carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public void write() {
    System.out.println("자동차명: " + this.carName);
    System.out.println("차량가격: " + this.price + "만원");
    System.out.println("차량색상: " + this.carColor);
  }
}


public class Ex06_CarInfo {
  public static void main(String[] args) {
    MyCar car1 = new MyCar();
    car1.setCarName("아반떼");
    car1.setPrice(2000);
    car1.setCarColor("화이트");
    
    MyCar car2 = new MyCar();
    car2.setCarName("미니쿠퍼");
    car2.setPrice(4000);
    car2.setCarColor("그린");
    
    System.out.println("***나의 자동차 정보***");
    car1.write();
    System.out.println("***나의 새 자동차 정보***");
    car2.write();
    String name = "h2llo";
    
  }
}
