package day0203;

public class Ex07_MemberTest {
  public static void main(String[] args) {
    Member member1 = new Member();
    member1.setData("이나영", "여자", "서울시 용산구");
    
    Member member2 = new Member();
    member2.setData("원빈", "남자", "서울시 용산구");
    
    Member member3 = new Member();
    member3.setData("정우성", "남자", "경기도 수원시");
    
    member1.write();
    System.out.println("------------------------------");
    member2.write();
    System.out.println("------------------------------");
    member3.write();
  }
}
