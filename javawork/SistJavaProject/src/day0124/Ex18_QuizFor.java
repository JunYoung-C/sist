package day0124;

public class Ex18_QuizFor {
  public static void main(String[] args) {
    for (int i = 1; i <= 3; i++) {
      System.out.println(i + ".Happy");
      for (int j = 1; j <= 4; j++) {
        System.out.print("\t" + j + ":Java");
      }
      System.out.println();
    }
  }
}
