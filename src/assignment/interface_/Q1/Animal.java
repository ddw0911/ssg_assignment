package assignment.interface_.Q1;

public abstract class Animal {

  int speed;
  double distance;

  Animal() {

  }

  Animal(int speed) {

  }

  abstract void run(int hours);


  double getDistance() {
    return this.distance;
  }
}
