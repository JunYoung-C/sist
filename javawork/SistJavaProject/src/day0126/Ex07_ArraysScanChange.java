package day0126;

import java.util.Scanner;

public class Ex07_ArraysScanChange {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);

    System.out.println("인원수를 입력하세요");
    int n = stdIn.nextInt();
    String[] names = new String[n];
    int[] scores = new int[n];
    
    for (int i = 0; i < n; i++) {
      System.out.print(i + 1 + "번째 학생명 : ");
      names[i] = stdIn.next();
      
      System.out.print(i + 1 + "번째 학생 점수 : ");
      scores[i] = stdIn.nextInt();
    }
    
    int[] ranks = new int[n];
    for (int i = 0; i < n; i++) {
      int rank = 1;
      for (int j = 0; j < n; j++) {
        if (scores[i] < scores[j]) {
          rank++;
        }
      }
      ranks[i] = rank;
    }
    System.out.println("번호\t이름\t점수\t등수");
    System.out.println("---------------------------");
    for (int i = 0; i < n; i++) {
      System.out.println(i + 1 + "\t" + names[i] + "\t" + scores[i] + "\t" + ranks[i]);
    }
    System.out.println("---------------------------");
    
    
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += scores[i];
    }
    double avg = (double) sum / n;
    
    System.out.println("합계 : " + sum);
    System.out.printf("평균 : %.2f", avg);
  }
}
