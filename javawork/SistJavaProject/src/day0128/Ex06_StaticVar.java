package day0128;

class InstCnt {
  static int instNum;
  
  public InstCnt() {
    instNum++;
    System.out.println("인스턴스 생성: " + instNum);
  }
}

public class Ex06_StaticVar {
  public static void main(String[] args) {
    InstCnt cnt1 = new InstCnt();
    InstCnt cnt2 = new InstCnt();
    InstCnt cnt3 = new InstCnt();
  }
}
