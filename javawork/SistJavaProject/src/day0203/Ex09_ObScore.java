package day0203;

class Score {
  private String name;
  private int java;
  private int spring;



  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getJava() {
    return java;
  }

  public void setJava(int java) {
    this.java = java;
  }

  public int getSpring() {
    return spring;
  }

  public void setSpring(int spring) {
    this.spring = spring;
  }

  public int getTot() {
    return java + spring;
  }
  
  public double getAvg() {
    return getTot() / 2.0;
  }
}


public class Ex09_ObScore {
  public static void main(String[] args) {
    Score s = new Score();
    
    s.setName("박지윤");
    s.setJava(90);
    s.setSpring(87);
    
    int tot = s.getTot();
    double avg = s.getAvg();
    
    
  }
}
