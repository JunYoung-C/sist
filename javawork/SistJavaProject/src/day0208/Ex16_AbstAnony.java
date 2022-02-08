package day0208;

abstract class AbstEx1 {
  abstract public void dataAdd();

  abstract public void dataList();
  // abstract public void dataUpdate();
  // abstract public void dataDelete();
}


class SubAbst extends AbstEx1 {

  @Override
  public void dataAdd() {
    // TODO Auto-generated method stub
    System.out.println("회원 추가");
  }

  @Override
  public void dataList() {
    // TODO Auto-generated method stub
    System.out.println("회원 목록 출력");
  }

}


public class Ex16_AbstAnony {
  AbstEx1 ab1 = new AbstEx1() {
    
    @Override
    public void dataList() {
      // TODO Auto-generated method stub
      System.out.println("데이터를 출력합니다.");
    }
    
    @Override
    public void dataAdd() {
      // TODO Auto-generated method stub
      System.out.println("데이터를 추가합니다.");
    }
  };
  
  public static void main(String[] args) {
    AbstEx1 ab1 = new Ex16_AbstAnony().ab1;
    ab1.dataAdd();
    ab1.dataList();
    
    AbstEx1 ab2 = new SubAbst();
    ab2.dataAdd();
    ab2.dataList();
  }
}
