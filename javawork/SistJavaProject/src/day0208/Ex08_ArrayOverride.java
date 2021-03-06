package day0208;

abstract class Game {
  public abstract void play();

  public abstract void stop();

}


class Nari extends Game {

  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("나리가 게임을 시작합니다.");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    System.out.println("나리가 게임을 종료합니다.");
  }

}


class Jongmin extends Game {

  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("종민이가 게임을 시작합니다.");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    System.out.println("종민이가 게임을 종료합니다.");
  }

}


class Ara extends Game {

  @Override
  public void play() {
    // TODO Auto-generated method stub
    System.out.println("아라가 게임을 시작합니다.");
  }

  @Override
  public void stop() {
    // TODO Auto-generated method stub
    System.out.println("아라가 게임을 종료합니다.");
  }

}


public class Ex08_ArrayOverride {
  public static void main(String[] args) {
    Game[] games = new Game[3];
    games[0] = new Nari();
    games[1] = new Ara();
    games[2] = new Jongmin();
    
    for (Game g : games) {
      g.play();
    }
    System.out.println("----------------------");
    for (int i = games.length - 1; i >= 0; i--) {
      games[i].stop();
    }
  }
}
