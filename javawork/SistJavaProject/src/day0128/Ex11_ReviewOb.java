package day0128;

class Sangpum {
  private String sangpum;
  int su;
  int dan;
  static String SHOPNAME = "이마트";
  
  
  public String getSangpum() {
    return sangpum;
  }
  public void setSangpum(String sangpum) {
    this.sangpum = sangpum;
  }
  public int getSu() {
    return su;
  }
  public void setSu(int su) {
    this.su = su;
  }
  public int getDan() {
    return dan;
  }
  public void setDan(int dan) {
    this.dan = dan;
  }
  public static String getSHOPNAME() {
    return SHOPNAME;
  }
  public static void setSHOPNAME(String sHOPNAME) {
    SHOPNAME = sHOPNAME;
  }
  
  
}
public class Ex11_ReviewOb {
  public static void main(String[] args) {
    System.out.println("[상점명: " + Sangpum.SHOPNAME + "]");
    Sangpum p1 = new Sangpum();
    p1.setSangpum("핸드크림");
    p1.setSu(10);
    p1.setDan(2500);
    
    Sangpum p2 = new Sangpum();
    p2.setSangpum("마우스");
    p2.setSu(20);
    p2.setDan(12000);
    
    System.out.println("상품명1: " + p1.getSangpum());
    System.out.println("수량: " + p1.getSu() + "개");
    System.out.println("단가: " + p1.getDan() + "원");
    System.out.println("------------------------------");
    System.out.println("상품명2: " + p2.getSangpum());
    System.out.println("수량: " + p2.getSu() + "개");
    System.out.println("단가: " + p2.getDan() + "원");
  }
}
