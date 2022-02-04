package day0204;

class Mango {
  private String writer;
  private String subjct;
  private static String message = "Happy Friday!!";
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getSubjct() {
    return subjct;
  }
  public void setSubjct(String subjct) {
    this.subjct = subjct;
  }
  public static String getMessage() {
    return message;
  }
  public static void setMessage(String message) {
    Mango.message = message;
  }
  
}
public class Ex01_ObMethodReview {
  
  public static void writeMango(Mango m) {
    System.out.println("망고 클래스 출력");
    System.out.println("작성자: " + m.getWriter());
    System.out.println("제목: " + m.getSubjct());
  }
  public static void main(String[] args) {
    
  }
}
