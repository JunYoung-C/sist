package day0210;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

// List 인터페이스를 구현한 클래스 - Vector, ArrayList
// 순차적으로 데이터가 들억나다.
// 중복데이터 허용
// 생성자가 디폴드인 경우 기본 할당크기 10, 넘치면 2배씩 증가
// 생성자가 (5, 3) - 할당크기 5, 증가시엔 3씩 증가(5, 8, 11...)
public class Ex02_List {
  public static void main(String[] args) {
    Vector<String> list1 = new Vector<>();
    List<String> list2 = new Vector<String>();
    List<String> list3 = new ArrayList<String>();
    
    System.out.println("초기 할당 크기: " + list1.capacity());
    System.out.println("초기 데이터 개수: " + list1.size());
    
    list1.add("사과");
    list1.add("수박");
    list1.add("딸기");
    list1.add("사과");
    list1.add("키위");
    list1.add("바나나");
    
    System.out.println("할당 크기: " + list1.capacity());
    System.out.println("데이터 개수: " + list1.size());
  
    System.out.println("출력 1");
    for (int i = 0; i < list1.size(); i++) {
      System.out.println(list1.get(i));
    }
    
    System.out.println("출력 2");
    for (String s : list1) {
      System.out.println(s);
    }
    
    System.out.println("출력 3");
    Iterator<String> iter = list1.iterator();
    while (iter.hasNext()) {
      System.out.println(iter.next());
    }
    
    System.out.println("출력 4");
    Object[] ob = list1.toArray();
    for (int i = 0; i < ob.length; i++) {
      System.out.println(ob[i]);
    }
    
    
  }
}
