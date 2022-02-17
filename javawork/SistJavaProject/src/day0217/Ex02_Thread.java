package day0217;

public class Ex02_Thread extends Thread{
  String name;
  int num;
  
  public Ex02_Thread(String name, int num) {
    this.name = name;
    this.num = num;
  }
  
  @Override
  public void run() {
    // TODO Auto-generated method stub
    super.run();
    
    for (int i = 1; i <= num; i++) {
    System.out.println(name + "===>" + i);
  }
  }
  
//  public void run() {
//    for (int i = 1; i <= num; i++) {
//      System.out.println(name + "===>" + i);
//    }
//  }
  
  public static void main(String[] args) {
    Ex02_Thread th1 = new Ex02_Thread("one", 300);
//    th1.run();
    th1.start(); // 
  }
}
