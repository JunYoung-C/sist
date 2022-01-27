package day0127;

public class Ex04_ArraysSortString {
  public static void main(String[] args) {
    String[] data = {"차동현", "류슬영", "임현정", "이경룡", "이용기", "신지환", "원연욱", "장수빈"};
    System.out.println("**정렬전 출력**");
    int len = data.length;
    for (int i = 0; i < len; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
    
    System.out.println("**정렬후 출력**");
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (data[i].compareTo(data[j]) > 0) {
          String tmp = data[i];
          data[i] = data[j];
          data[j] = tmp;
        }
      }

    }
    for (int i = 0; i < len; i++) {
      System.out.print(data[i] + " ");
    }
    System.out.println();
    
  }
}
