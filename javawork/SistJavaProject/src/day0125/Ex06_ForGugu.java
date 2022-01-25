package day0125;

public class Ex06_ForGugu {
  public static void hight_gugu() {
    for (int i = 2; i <= 9; i++) {
      System.out.println("[" + i + "단]");
      for (int j = 1; j <= 9; j++) {
        System.out.println(i + "X" + j + "=" + (i * j));
      }
    }
  }

  public static void width_gugu() {
    for (int i = 2; i <= 4; i++) {
      System.out.print("[" + i + "단]\t");
    }
    System.out.println();
    for (int j = 1; j <= 9; j++) {
      for (int i = 2; i <= 4; i++) {
//        System.out.print(i + "X" + j + "=" + (i * j));
        System.out.printf("%dX%d=%2d\t", i, j, i * j);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
//    hight_gugu();
    width_gugu();
  }
}
