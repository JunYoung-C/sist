package day0121;

public class Ex08_CharAt {
  public static void main(String[] args) {
    String jumin = "951102-4576545";

    char seventh = jumin.charAt(7);

//    switch (seventh) {
//      case '1':
//        System.out.println("남자");
//        break;
//      case '2':
//        System.out.println("여자");
//        break;
//      case '3':
//        System.out.println("2000년 이후 남자");
//        break;
//      case '4':
//        System.out.println("2000년 이후 여자");
//        break;
//    }

    String result;
    if (seventh == '1') {
      result = "남자";
    } else if (seventh == '1') {
      result = "여자";
    } else if (seventh == '1') {
      result = "2000년 이후 남자";
    } else {
      result = "2000년 이후 여자";
    }
    
    System.out.println("당신은 " + result + "입니다.");
  }
}
