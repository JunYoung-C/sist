package day0119;

public class Ex03_CaseArgsTest {
  public static void main(String[] args) {
    /*
     * 상품명: 아이폰13 mini
     * 수량: 20개
     * 단가: 950000원
     * 총액: ?원
     */
    
    String firstName = args[0];
    String secondName = args[1];
    int cnt = Integer.parseInt(args[2]);
    int price = Integer.parseInt(args[3]);
    int total = cnt * price;
    
    System.out.println("상품명: " + firstName + " " + secondName);
    System.out.println("수량: " + cnt + "개");
    System.out.println("단가: " + price+ "원");
    System.out.println("총금액: " + total+ "원");
  }
}
