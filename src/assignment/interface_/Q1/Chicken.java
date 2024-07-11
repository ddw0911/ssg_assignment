package assignment.interface_.Q1;

public class Chicken extends Animal implements Cheatable {

  Chicken() {

  }

  Chicken(int speed) {
    this.speed = speed;
  }

  @Override
  void run(int hours) {
    this.distance = hours * speed;
  }

  @Override
  public void fly() {
    this.speed *= 2;
  }
}
