package day0127;

public class Ex05_ArraysSort {
  public static void main(String[] args) {
    String[] name = {"이효리", "강호동", "김태희", "유재석", "하하"};
    int[] ages = {39, 45, 33, 38, 32};
    int len = name.length;
    
    for (int i = 0; i < len - 1; i++) {
      for (int j = i + 1; j < len; j++) {
        if (name[i].compareTo(name[j]) > 0) {
          String tmp = name[i];
          name[i] = name[j];
          name[j] = tmp;
          
          int tmpAge = ages[i];
          ages[i] = ages[j];
          ages[j] = tmpAge;
        }
      }
    }
    
    System.out.println("번호\t이름\t나이");
    for (int i = 0; i < len; i++) {
      System.out.println((i + 1) + "\t" + name[i] + "\t" + ages[i]);
    }
  }
  
}
