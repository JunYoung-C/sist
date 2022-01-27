package day0127;

import java.util.Scanner;

public class Ex10_ArraysBinggo {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int[][] pz = new int[3][3];

    int binggo = 0;

    while (true) {
      binggo = 0;
      System.out.println("같은 숫자가 나오면 빙고");
      for (int i = 0; i < pz.length; i++) {
        for (int j = 0; j < pz[i].length; j++) {
          pz[i][j] = (int) (Math.random() * 3) + 1;
        }
      }

      for (int i = 0; i < pz.length; i++) {
        for (int j = 0; j < pz[i].length; j++) {
          System.out.printf("%4d", pz[i][j]);
        }
        System.out.println();
      }

      for (int i = 0; i < pz.length; i++) {
        if (pz[i][0] == pz[i][1] && pz[i][2] == pz[i][1]) {
          binggo++;
        }

        if (pz[0][i] == pz[1][i] && pz[1][i] == pz[2][i]) {
          binggo++;
        }
      }
      if (pz[0][0] == pz[1][1] && pz[1][1] == pz[2][2]) {
        binggo++;
      }
      if (pz[0][2] == pz[1][1] && pz[1][1] == pz[2][0]) {
        binggo++;
      }
      
      if (binggo == 0) {
        System.out.println("\t꽝!!");
      } else {
        System.out.println("\t빙고" + binggo + "개");
      }
      
      System.out.println("엔터를 누르면 다음 난수가 발생합니다.(종료: Q)");
      String ent = stdIn.nextLine();
      
      if (ent.equalsIgnoreCase("q")) {
        System.out.println("게임을 종료합니다.");
        break;
      }
    }

    
  }

}
