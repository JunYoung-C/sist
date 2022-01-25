package day0121;

public class Ex09_Substring {
  public static void main(String[] args) {
    String str = "나는 강남 쌍용교육센터에서 자바를 공부중입니다.";
    
    char ch = str.charAt(4);
    String word1 = str.substring(3);
    String word2 = str.substring(6, 11);
  }
}
