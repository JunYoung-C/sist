package day0128;

class MyDate {
  private int year;
  private int month;
  private int day;

  public MyDate() {
    super();
  }

  public MyDate(int year, int month, int day) {
    super();
    this.year = year;
    this.month = month;
    this.day = day;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }


}


public class Ex10_TestMyDate {
  public static void main(String[] args) {
    MyDate date = new MyDate(2022, 12, 25);
    System.out.println(date.getYear());
    System.out.println(date.getMonth());
    System.out.println(date.getDay());
  }
}
