package assignment.exception;

public class CellPhone {

  String model;
  double battery;
  static final int MAX_BATTERY = 100;
  static final int MIN_BATTERY = 0;

  public CellPhone() {

  }

  public CellPhone(String model) {
    this.model = model;
  }

  void call(int time) {
    try {
      MyException.prob2CallEx(time);
      System.out.println("통화시간 : " + time + "분");
      this.battery -= time * 0.5;
      if (this.battery < MIN_BATTERY) {
        this.battery = MIN_BATTERY;
      }
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }

  void charge(int time) {
    try {
     MyException.prob2ChargeEx(time);
      System.out.println("충전시간 : " + time + "분");
      this.battery += time * 3;
      if (this.battery > MAX_BATTERY) {
        this.battery = MAX_BATTERY;
      }
    } catch (MyException e) {
      System.out.println(e.getMessage());
    }
  }

  void printBattery() {
    System.out.println("남은 배터리 양 : " + this.battery);
  }
}
