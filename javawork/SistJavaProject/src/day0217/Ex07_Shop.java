package day0217;

import java.io.Serializable;

public class Ex07_Shop implements Serializable {
  private String productName;
  private int amount;
  private int price;

  public Ex07_Shop(String productName, int amount, int price) {
    super();
    this.productName = productName;
    this.amount = amount;
    this.price = price;
  }

  public Ex07_Shop() {
    super();
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }


}
