package day0126;

public class Ex01_String {
  public static void main(String[] args) {
    System.out.println("String 객체에 대한 멤버 메서드를 공부합니다.");
    String str1 = "apple";
    String str2 = "Apple";
    String str3 = "Have a Nice Day";
    String str4 = "   Happy Day   ";
    System.out.println("str3의 길이 : " + str3.length());
    System.out.println("str4의 길이 : " + str4.length());
    System.out.println("앞뒤 공백 제거 str4의 길이 : " + str4.trim().length());
    System.out.println("*" + str4 + "*");
    System.out.println("*" + str4.trim() + "*");
    System.out.println("str3에서 0번 문자: " + str3.charAt(0));
    System.out.println("str3에서 H의 인덱스: " + str3.indexOf('H'));
    System.out.println("str3에서 Have출력: " + str3.substring(str3.indexOf('H'), str3.indexOf('H') + 4));
    System.out.println("str3에서 Nice 출력: " + str3.substring(str3.indexOf('N'), str3.indexOf('N') + 4));
    
    System.out.println("문자열 비교: " + str1.equals(str2));
    System.out.println("문자열 비교: " + str1.equalsIgnoreCase(str2));
    
    // a.compare(b)
    // a가 작은 경우 -(알파벳 차이만큼 마이너스 값)
    // a가 큰 경우 +
    
    System.out.println(str1.compareTo(str2)); // a 97, A 65
    System.out.println(str1.compareTo(str1));
    System.out.println("computer".compareTo("command")); //p와 m을 비교
    
    System.out.println("str3가 Have로 시작하면 true: " + str3.startsWith("Have"));
    
    System.out.println(str3.endsWith("Day"));
    System.out.println(str3.endsWith("day"));
    
    //문자열 분리하는 메서드 split
    String str5 = "red,blue,green,yellow,pink,white";
    System.out.println("str5를 컬러로 분리하여 출력하기");
    String[] arr = str5.split(",");
    System.out.println(",로 구분된 색상 개수: " + arr.length);
    for (String color: arr) {
      System.out.println(color);
    }
  
    System.out.println("str3의 소문자 출력: " + str3.toLowerCase());
    System.out.println("str3의 소문자 출력: " + str3.toUpperCase());
    
    String a= String.valueOf(100);
    String b = String.valueOf(12.345);
    System.out.println(a + b);
    
    String a2 = 100 + "";
    String b2 = 23.5 + "";
    System.out.println(a2 + b2);
    
    System.out.println("문자열의 일부를 변환");
    System.out.println(str3.replace('a', '*'));
    System.out.println(str3.replace("Nice", "Good"));
  }
}
