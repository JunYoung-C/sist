package day0209;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// <제네릭> 명시한 자료형
// <컬렉션> 자료구조(set, vector, arrayList)
// (인터페이스 or 클래스명)<데이터형> 객체이름 = new 클래스명<데이터형>;
// 배열과 달리 가변적

// List : 순서가 중요할 때 사용, 인덱스 위치를 알고있다. 중복 가능
// Set : 유일성이 중요할 때, 중복허용하지 않는다.
// Map : 키, 값

public class Ex16_HashSet {
  public static void main(String[] args) {
    Set<String> set1 = new HashSet<String>(); // Set은 인터페이스라서 객체 생성 안됨
    
    set1.add("사과");
    set1.add("바나나");
    set1.add("키위");
    set1.add("사과");
    set1.add("오렌지");
    set1.add("수박");
    
    System.out.println("데이터 개수 : " + set1.size());
    
    System.out.println("출력 1");
    for (String s : set1) {
      System.out.println(s);
    }
    
    System.out.println("출력 2");
    Iterator<String> iterator = set1.iterator();
    while (iterator.hasNext()) {
      String s = iterator.next();
      System.out.println(s);
    }
    
    System.out.println("출력 3");
    Object[] ob = set1.toArray();
    for (int i = 0; i < ob.length; i++) {
      System.out.println(ob[i]);
    }
  }
}
