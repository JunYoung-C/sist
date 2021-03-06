package day0209;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex17_Set {
  public static void main(String[] args) {
    Set<Integer> set1 = new HashSet<>();
    
    set1.add(5);
    set1.add(11);
    set1.add(45);
    set1.add(78);
    set1.add(5);
    
    System.out.println("개수: " + set1.size());
    System.out.println("출력 1");
    for (int i : set1) {
      System.out.println(i);
    }
    
    System.out.println("출력 2");
    Iterator<Integer> iter = set1.iterator();
    while (iter.hasNext()) {
      int i = iter.next();
      System.out.println(i);
    }
    
    System.out.println("출력 3");
    Object[] ob = set1.toArray();
    for (int i = 0; i < ob.length; i++) {
      System.out.println(ob[i]);
    }
  }
}
