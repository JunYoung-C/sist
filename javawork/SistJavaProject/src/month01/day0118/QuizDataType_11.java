package month01.day0118;

public class QuizDataType_11 {

  public static void main(String[] args) {
    /*
     * 메인 파라메터 값(args)으로 3과목의 점수를 읽어서 총점과 평균을 출력하시오(소수점 이하 2자리)
     * 변수는 java, jsp, spring
     */
    
    int java = Integer.parseInt(args[0]);
    int jsp = Integer.parseInt(args[1]);
    int spring = Integer.parseInt(args[2]);

    int tot = java + jsp + spring;
    double avg = (double) tot / 3;
    
    System.out.println("java=" + java + ", jsp=" + jsp + ", spring=" + spring);
    System.out.println("총점=" + tot);
    System.out.printf("평균=%.2f", avg);
  }

}
