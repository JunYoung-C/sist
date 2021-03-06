package day0128;

public class Student {
  private String name;
  private int age;
  
  //생성자(명시적 생성자)
  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }
  
  public Student() {
    
  }
  
  //setter 메서드
  // 인스턴스 변수에 저장된 데이터를 수정할 목적으로 사용 - set변수명
  //저장 용도이므로 결과값이 없다.
  public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  // getter 메서드
  // 인스턴스 병수에 저장된 데이터를 조회할 목적으로 사용 - get변수명
  // 데이터 얻는 목적, 호출 데이터를 넘겨주는 데이터가 없으므로 인자 없음
  // 실행 결과를 돌려주므로 return 결과값으로 지정
  // 리턴 타입도 결과값 타입으로 지정
  public String getName() {
    return name;
  }
  public int getAge() {
    return age;
  }
}
