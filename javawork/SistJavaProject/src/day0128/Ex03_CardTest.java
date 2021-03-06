package day0128;

public class Ex03_CardTest {
  public static void main(String[] args) {
    //static 접근 테스트
    Card.width = 10;
    Card.height = 20;
    
    System.out.println(Card.width);
    System.out.println(Card.height);
    
    Card c1 = new Card();
    System.out.println(c1.kind);
    System.out.println(c1.num);
    
    c1.kind = "Heart";
    c1.num = 7;
    
    Card c2 = new Card();
    c2.kind = "Spade";
    c2.num = 4;
    
    System.out.println(c1.kind + ", " + c1.num + ", " + Card.width + ", " + Card.height);
    System.out.println(c2.kind + ", " + c2.num + ", " + Card.width + ", " + Card.height);
    
    Card.width = 50;
    Card.height = 80;
    
    System.out.println(c1.kind + ", " + c1.num + ", " + Card.width + ", " + Card.height);
    System.out.println(c2.kind + ", " + c2.num + ", " + Card.width + ", " + Card.height);
  }
}
