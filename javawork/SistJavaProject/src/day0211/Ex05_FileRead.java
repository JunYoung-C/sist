package day0211;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex05_FileRead {

  static final String FILENAME = "C:\\sist\\javawork\\SistJavaProject\\sungjuk.txt";
  FileWriter fw;
  FileReader fr;
  BufferedReader br;
  Scanner stdIn = new Scanner(System.in);

  public void sungjukIn() {
    System.out.println("이름은?");
    String name = stdIn.nextLine();
    System.out.println("점수는?");
    int score = Integer.parseInt(stdIn.nextLine());

    try {
      fw = new FileWriter(FILENAME, true);

      fw.write(name + "\n");
      fw.write(score + "\n");
      System.out.println("학생 점수가 저장됨");
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        fw.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public void fileRead() {
    // 제목부터 출력
    System.out.println("\t**학생정보**");
    System.out.println("번호\t이름\t점수\t학점");
    System.out.println("--------------------------------");

    try {
      fr = new FileReader(FILENAME);
      br = new BufferedReader(fr);

      int num = 0;
      while (true) {
        String name = br.readLine();
        if (name == null) {
          break;
        }
        int score = Integer.parseInt(br.readLine());

        char grade = getGrade(score);

        System.out.println((++num) + "\t" + name + "\t" + score + "\t" + grade);
      }

      System.out.println("출력 끝");
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      try {
        br.close();
        fr.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }


  }

  public char getGrade(int score) {
    char ch;

    if (score >= 90) {
      ch = 'A';
    } else if (score >= 80) {
      ch = 'B';
    } else if (score >= 70) {
      ch = 'C';
    } else if (score >= 60) {
      ch = 'D';
    } else {
      ch = 'F';
    }
    return ch;
  }

  public static void main(String[] args) {
    Ex05_FileRead T = new Ex05_FileRead();
    int num;
    while (true) {
      System.out.println("1.학생정보입력\t2.학생정보출력\t9.종료");
      num = Integer.parseInt(T.stdIn.nextLine());
      if (num == 1) {
        T.sungjukIn();
      } else if (num == 2) {
        T.fileRead();
      } else {
        System.out.println("종료합니다.");
        break;
      }
    }
    System.out.println();
  }
}
