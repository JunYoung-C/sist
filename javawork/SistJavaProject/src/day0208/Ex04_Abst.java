package day0208;

abstract class Board {
  public abstract void process();
}
class List extends Board {

  @Override
  public void process() {
    // TODO Auto-generated method stub
    System.out.println("게시판에 글을 출력합니다");
  }
  
}

class Write extends Board {

  @Override
  public void process() {
    // TODO Auto-generated method stub
    System.out.println("게시판에 글을 작성합니다");
  }
  
}

class Update extends Board {

  @Override
  public void process() {
    // TODO Auto-generated method stub
    System.out.println("게시판에 글을 수정합니다");
  }
  
}

class Delete extends Board {

  @Override
  public void process() {
    // TODO Auto-generated method stub
    System.out.println("게시판에 글을 삭제합니다");
  }
  
}


public class Ex04_Abst {

}
