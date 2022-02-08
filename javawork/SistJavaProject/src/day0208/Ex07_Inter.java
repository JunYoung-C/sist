package day0208;

interface GameA {
  void play();
}


interface GameB extends GameA {
  void stop();
}


class MyGame implements GameB {

  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("play 호출");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    System.out.println("stop 호출");
  }

}


public class Ex07_Inter {
  public static void main(String[] args) {
    MyGame mygame= new MyGame();
    
    mygame.play();
    mygame.stop();
  }
}
