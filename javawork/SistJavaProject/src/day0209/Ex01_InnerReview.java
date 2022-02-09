package day0209;

interface Sawon {
  public void addSawon();
  public void deleteSawon();
  public void listSawon();
}
public class Ex01_InnerReview {
  public static Sawon sawon = new Sawon() {
    
    @Override
    public void listSawon() {
      // TODO Auto-generated method stub
      System.out.println("사원 명단 출력");
    }
    
    @Override
    public void deleteSawon() {
      // TODO Auto-generated method stub
      System.out.println("사원 퇴사");
    }
    
    @Override
    public void addSawon() {
      // TODO Auto-generated method stub
      System.out.println("사원 입사");
    }
  };
  
  public static void main(String[] args) {
    sawon.addSawon();
    sawon.listSawon();
    sawon.deleteSawon();
  }
}
