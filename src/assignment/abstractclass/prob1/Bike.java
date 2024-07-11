package assignment.abstractclass.prob1;

public class Bike extends Wheeler{
    private int bikeWheel;

    final int maxSpeed = 40;
    final int minSpeed = 10;
    Bike() {

    }

    Bike(String carName, int velocity, int wheelNumber) {
        this.carName = carName;
        this.velocity = velocity;
        this.bikeWheel = wheelNumber;
    }

    @Override
    void countWheel() {
        System.out.println(carName + " : 바퀴 " + bikeWheel + "개입니다");

    }

    @Override
    void speedUp(int speed) {
        velocity += speed;
        if (velocity > maxSpeed) {
            velocity = maxSpeed;
        }
        System.out.println(carName + "의 현재 속도는 " + velocity + " 입니다.");

    }

    @Override
    void speedDown(int speed) {
        velocity -= speed;
        if (velocity < minSpeed) {
            velocity = minSpeed;
            System.out.println(carName + "의 최저속도 위반으로 속도를 " + velocity + "으로 올립니다.");
        }
    }

    @Override
    void infoCurrentVelocity() {
        System.out.println(carName + "의 현재 속도는 " + velocity + " 입니다.");
    }
}
