package day0208;

class Car {
  private String carName;
  private String carColor;

  public Car(String carName, String carColor) {
    super();
    this.carName = carName;
    this.carColor = carColor;
  }

  public Car() {
    super();
  }

  public String getCarName() {
    return carName;
  }

  public void setCarName(String carName) {
    this.carName = carName;
  }

  public String getCarColor() {
    return carColor;
  }

  public void setCarColor(String carColor) {
    this.carColor = carColor;
  }

  public void writeCar() {
    System.out.println("내차는 " + carName + "이고 " + carColor + " 입니다.");
  }
}


class MyCar extends Car {
  private int carPrice;

  public int getCarPrice() {
    return carPrice;
  }

  public void setCarPrice(int carPrice) {
    this.carPrice = carPrice;
  }

  public MyCar() {};

  public MyCar(String carName, String carColor, int carPrice) {
    super(carName, carColor);
    this.carPrice = carPrice;
  }

  @Override
  public void writeCar() {
    // TODO Auto-generated method stub
    super.writeCar();
    System.out.println("내차 가격은 " + carPrice + "만원 이에요");
  }
}


public class Ex01_Inherit {
  public static void main(String[] args) {
    MyCar car1 = new MyCar();
    car1.setCarName("그랜져");
    car1.setCarColor("진주색");
    car1.setCarPrice(3500);

    MyCar car2 = new MyCar("테슬라", "블루", 5500);
    
    car1.writeCar();
    System.out.println("---------------------");
    car2.writeCar();
  }
}
