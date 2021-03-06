package day0210;

import java.util.ArrayList;
import java.util.List;

public class Ex04_ArrayList {
  public static void main(String[] args) {
    String[] str = {"장비", "후리지아", "다알리아", "백합", "수국"};
    List<String> list = new ArrayList<String>();
    int len = str.length;
    for (int i = 0; i < len; i++) {
      list.add(str[i]);
    }
    
    System.out.print("출력 1(for) : ");
    for (int i = 0; i < len; i++) {
      System.out.print(str[i] + " ");
    }
    System.out.println();
    
    System.out.print("출력 2(foreach) : ");
    for (String s : list) {
      System.out.print(s + " ");
    }
    System.out.println();
  }
}
