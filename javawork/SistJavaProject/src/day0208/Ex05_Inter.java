package day0208;

interface InterA {
  public void draw();

  public void write();
}


interface InterB {
  public void play();
}


class InterImpl implements InterA, InterB {

  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("축구를 합니다.");
  }

  @Override
  public void draw() {
    // TODO Auto-generated method stub
    System.out.println("그림을 그려요.");
  }

  @Override
  public void write() {
    // TODO Auto-generated method stub
    System.out.println("영어 글쓰기중.");
  }

}


public class Ex05_Inter {
  public static void main(String[] args) {
    InterImpl interImpl = new InterImpl();
  }
}
