package day0209;

public class Ex15_StringBuffer {
  public static void main(String[] args) {
    // 문자열 저장, 편집 기능이 추가된 자료형
    StringBuffer sb = new StringBuffer();
    
    sb.append("Happy");
    sb.append("Nice");
    sb.append(200);
    sb.append(3.14);
    sb.append('A');
    
    System.out.println(sb);
  }
}
