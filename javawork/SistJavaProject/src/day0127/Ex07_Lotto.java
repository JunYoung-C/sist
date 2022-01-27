package day0127;

public class Ex07_Lotto {
  public static void main(String[] args) {
    // 로또를 출력해보자. 중복 x, 오름차순 정렬
    int[] lotto = new int[6];

    for (int i = 0; i < lotto.length; i++) {
      lotto[i] = (int) (Math.random() * 45) + 1;

      for (int j = 0; j < i; j++) {
        if (lotto[i] == lotto[j]) {
          i--;
          break;
        }
      }
    }

    for (int i : lotto) {
      System.out.print(i + " ");
    }
  }
}
