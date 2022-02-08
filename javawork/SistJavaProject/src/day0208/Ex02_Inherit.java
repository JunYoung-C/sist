package day0208;

class Color {
  public void hello() {
    System.out.println("안녕~~ 오늘 색칠공부 잘 해봅시다.");
  }
}


class Red extends Color {
  public void process() {
    System.out.println("나는 모든 벽을 빨강으로 칠할께");
  }
}


class Blue extends Color {
  public void process() {
    System.out.println("나는 모든 벽을 파랑으로 칠할께");
  }
}


class Green extends Color {
  public void process() {
    System.out.println("나는 모든 벽을 초록으로 칠할께");
  }
}


public class Ex02_Inherit {
  public static void main(String[] args) {
    System.out.println("1. Red로 선언 Red로 생성");
    Red red = new Red();
    red.hello();
    red.process();

    System.out.println("1. Blue로 선언 Blue로 생성");
    Blue blue = new Blue();
    blue.hello();
    blue.process();
    
    System.out.println("1. Green로 선언 Green로 생성");
    Green green = new Green();
    green.hello();
    green.process();
    
    Color c = new Red();
    c.hello();
    //c.process(); 부모한테는 없고 자식만 가지고 있는 메서드 호출 불가
  }
}
