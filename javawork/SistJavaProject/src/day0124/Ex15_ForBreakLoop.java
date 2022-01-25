package day0124;

public class Ex15_ForBreakLoop {
  public static void main(String[] args) {
    loop: for (int i = 2; i <= 9; i++) {
      for (int j = 1; j<= 9; j++) {
        if (j == 5) {
          break loop;
        }
        System.out.println(i + "X" + j + "=" + i * j);
      }
    }
  }
}
