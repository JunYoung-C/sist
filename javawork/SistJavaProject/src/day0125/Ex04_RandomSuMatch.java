package day0125;

import java.util.Scanner;

public class Ex04_RandomSuMatch {
  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int answer = (int)(Math.random() * 100 + 1);
    
    System.out.println("여러 회차에 걸쳐서 난수 알아맞추기");
    System.out.println("테스트 용 정답 출력 : " + answer);
    int i = 0;
    int num;
    
    while (true) {
      i++;
      System.out.print(i + ": ");
      num = stdIn.nextInt();
      if( answer > num) {
        System.out.println(num + "보다 큽니다.");
      } else if (answer < num) {
        System.out.println(num + "보다 작습니다.");
      } else {
        System.out.println("맞아요~ 정답은 " + answer + "입니다.");
        break;
      }
    }
    
  }
}
