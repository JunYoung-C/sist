package day0119;

public class Ex02_CaseArgsTest {
  public static void main(String[] args) {
    /*
     * 이름: 최지우 
     * JAVA점수: 88점 
     * JSP점수: 99점 
     * 합계 : 187점
     */

    String name = args[0];
    int java = Integer.parseInt(args[1]);
    int jsp = Integer.parseInt(args[2]);
    int tot = java + jsp;

    System.out.println("이름: " + name);
    System.out.println("JAVA점수: " + java + "점");
    System.out.println("JSP점수: " + jsp + "점");
    System.out.println("합계: " + tot + "점");

  }
}
