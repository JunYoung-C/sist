package day0126;

import java.util.Scanner;

public class Ex10_ArraysStringSearch {
  public static void main(String[] args) {
    // 이름을 입력해서 그 이름이 몇번째 있는지 
    // 그 이름이 없습니다를 없다고 출력
    // 끝이라고 입력하면 검색을 종료
    Scanner stdIn = new Scanner(System.in);
    String[] data = {"최준영", "조정언", "임현정", "장수빈", "조아라", "이용기", "이경룡", "유태호", "원연욱"};
    
    int index = 0;
    boolean flag;
    while (true) {
      System.out.println("검색할 이름을 입력하세요");
      String name = stdIn.next();
      flag = false;
      if (name.equals("끝")) {
        System.out.println("검색을 종료합니다.");
        break;
      }
      
      for (int i = 0; i < data.length; i++) {
        if (name.equals(data[i])) {
          index = i;
          flag = true;
          break;
        }
      }
      
      if (flag) {
        System.out.println("해당 이름은 " + (index + 1) + "번째에 있습니다.");
      } else {
        System.out.println("해당 이름은 존재하지 않습니다.");
      }
    }
  }
}
