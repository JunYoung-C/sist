package day0210;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Ex05_VectorBoard {

  List<Board> list = new Vector<>();

  public void inputData() {
    Scanner stdIn = new Scanner(System.in);
    String name, subject, content;

    System.out.println("작성자명?");
    name = stdIn.next();
    System.out.println("제목?");
    subject = stdIn.next();
    System.out.println("내용?");
    content = stdIn.next();

    list.add(new Board(name, subject, content));
    System.out.println("전체 데이터 개수: " + list.size() + "개");
  }

  public void writeData() {
    System.out.println("**게시판**");
    System.out.println("------------------------------");
    for (int i = 0; i < list.size(); i++) {
      Board b = list.get(i);
      System.out.println("No: " + (i + 1) + "\t작성자: " + b.getName());
      System.out.println("제목: " + b.getContent());
      System.out.println("내용: " + b.getSubject());
      System.out.println("-------------------------");
    }
  }

  public static void main(String[] args) {
    Ex05_VectorBoard vt = new Ex05_VectorBoard();
    Scanner stdIn = new Scanner(System.in);
    int n;
    
    while (true) {
      System.out.println("1. 추가 2. 전체출력 9. 종료");
      n = stdIn.nextInt();
      
      if (n == 1) {
        vt.inputData();
      } else if (n == 2) {
        vt.writeData();
      } else {
        System.out.println("종료");
        break;
      }
    }
  }
}
