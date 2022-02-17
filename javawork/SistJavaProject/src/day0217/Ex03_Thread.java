package day0217;

public class Ex03_Thread extends Thread {
  String name;
  int num;

  public Ex03_Thread(String name, int num) {
    this.name = name;
    this.num = num;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub
    super.run();

    for (int i = 1; i <= num; i++) {
      System.out.println(name + "==>" + i);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    Ex03_Thread ex1 = new Ex03_Thread("one", 300);
    Ex03_Thread ex2 = new Ex03_Thread("two", 300);
    Ex03_Thread ex3 = new Ex03_Thread("three", 300);

    Thread th1 = new Thread(ex1);
    Thread th2 = new Thread(ex2);
    Thread th3 = new Thread(ex3);
    
    th1.start();
    th2.start();
    th3.start();
  }
}
