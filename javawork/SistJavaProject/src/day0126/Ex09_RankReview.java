package day0126;

public class Ex09_RankReview {
  public static void main(String[] args) {
    String[] names = {"강나리", "곽경태", "김은비", "김종민", "김주찬"};
    int[] javaScores = {99, 78, 89, 67, 100};
    int[] oracleScores = {77, 66, 88, 99, 56};
    int len = names.length;
    
    int[] sums = new int[len];
    double[] avgs = new double[len];
    int[] ranks = new int[len];
    
    for (int i = 0; i < len; i++) {
      sums[i] = javaScores[i] + oracleScores[i];
      avgs[i] = (double) sums[i] / 2;
    }
    
    for (int i = 0; i < len; i++) {
      int rank = 1;
      for (int j = 0; j < len; j++) {
        if (avgs[i] < avgs[j]) {
          rank++;
        }
      }
      ranks[i] = rank;
    }
    
    System.out.println("번호\t이름\t자바\t오라클\t총점\t평균\t등수");
    for (int i = 0; i < len; i++) {
//      System.out.println(names[i] + "\t" + javaScores[i] + "\t" + oracleScores[i] + "\t" + sums[i] + "\t" + avgs[i] + "\t" + ranks[i]);
      System.out.printf("%d\t%s\t%d\t%d\t%d\t%.1f\t%d\n", (i + 1), names[i], javaScores[i], oracleScores[i], sums[i], avgs[i], ranks[i]);
    }
    
    
  }
}
