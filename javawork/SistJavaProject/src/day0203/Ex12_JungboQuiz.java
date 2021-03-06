package day0203;

class Jungbo {
  private String name;
  private String abo;
  private int age;

  public Jungbo(String name, String abo, int age) {
    super();
    this.name = name;
    this.abo = abo;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAbo() {
    return abo;
  }

  public void setAbo(String abo) {
    this.abo = abo;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public static void showTitle() {
    System.out.println("이름\t혈액형\t나이");
    System.out.println("=====================");
  }
  public void write() {
    System.out.println(this.name + "\t" + this.abo + "\t" + this.age+ "세");
  }
}


public class Ex12_JungboQuiz  {
  public static void main(String[] args) {

    Jungbo[] jungbos = new Jungbo[3]; 
    jungbos[0] = new Jungbo("김은비", "O형", 20);
    jungbos[1] = new Jungbo("김주찬", "A형", 21);
    jungbos[2]= new Jungbo("김종민", "AB형", 18);
    Jungbo.showTitle();
    for (Jungbo j : jungbos) {
      j.write();
    }
  }
}
