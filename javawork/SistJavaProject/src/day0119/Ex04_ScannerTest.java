package day0119;

import java.util.Scanner;

public class Ex04_ScannerTest {
  public static void main(String[] args) {
    // Scanner라는 클래스는 문자열이나 숫자 모두 키보드로 입력받으려 할 때 생성
    Scanner sc = new Scanner(System.in);
    
    String name;
    
    System.out.print("이름을 입력해 보세요==>");
    name = sc.nextLine(); //한줄을 문자로 읽어온다. (공백 사용 가능)
    
    System.out.print("당신의 나이는 몇살?==>");
//    int age = sc.nextInt();
    int age = Integer.parseInt(sc.nextLine());
    // 숫자 입력 후 엔터누르면 그 엔터가 키보드의 버퍼로 저장되어서 다음 문자 읽을 때 먼저 읽어버리는 문제 발생
    // 다음 문자열 읽기 전에 엔터를 읽어서 없애면 된다.
    
    System.out.print("사시는 지역은?==>");
    String city = sc.nextLine();
    
    System.out.println("나의 이름은 " + name + "입니다.");
    System.out.println("나의 나이는 " + age + "입니다.");
    System.out.println("저는 " + city + "지역에 살아요");
    
  }
}
