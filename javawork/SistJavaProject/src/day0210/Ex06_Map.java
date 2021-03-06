package day0210;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Ex06_Map {
  public static void main(String[] args) {
    Map<String, String> map = new HashMap<String, String>();
    
    map.put("name", "유재석");
    map.put("age", "23");
    map.put("addr", "서울시 노원구");
    map.put("name", "수지");
    
    System.out.println("size: " + map.size());
    System.out.println("키값을 정확하게 알면 value를 얻는다.");
    System.out.println("이름: " + map.get("name"));
    System.out.println("나이: " + map.get("age"));
    System.out.println("주소: " + map.get("addr"));
    
    System.out.println("혈액형: " + map.get("blood"));
    
    System.out.println("키값을 먼저 한번에 얻느 후 값을 얻기");
    Set<String> keySet = map.keySet();
    
    System.out.println("방법 1");
    for (String key : keySet) {
      System.out.println("key -> " + map.get(key));
      
    }
    
    System.out.println("방법 2");
    Iterator<String> keyIter = keySet.iterator();
    while (keyIter.hasNext()) {
      System.out.println("key -> " + map.get(keyIter.next()));
    }
  }
}
