package assignment.interface_.Q1;

public class Dog extends Animal{

  Dog() {

  }

  Dog(int speed) {
    this.speed = speed;
  }

  @Override
  void run(int hours) {
    this.distance =  speed * hours / 2.0;
    System.out.println("개의 이동거리=" + getDistance());
  }
}
