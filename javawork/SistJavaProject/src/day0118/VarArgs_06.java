package day0118;

public class VarArgs_06 {
  public static void main(String[] args) {
    /*
     * 내이름은 임현정
     * 자바 점수는 88
     * 오라클 점수는 88
     * 두 과목의 합계는 176점 입니다.
     */
    String name = args[0];
    int java = Integer.parseInt(args[1]);
    int oracle = Integer.parseInt(args[2]);
    int sum = java + oracle;
    
    System.out.println("내 이름은 " + name);
    System.out.println("자바 점수는 " + java);
    System.out.println("오라클 점수는 " + oracle);
    System.out.println("두 과목의 합계는 " + sum + "점 입니다.");
    
  }
}
