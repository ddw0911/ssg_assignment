package assignment.abstractclass.prob1;

public class Truck extends Wheeler {
    private int truckWheel;
    final int maxSpeed = 100;
    final int minSpeed = 50;

    @Override
    void countWheel() {
        System.out.println(carName + " : 바퀴 " + truckWheel + "개입니다");
    }

    @Override
    void speedUp(int speed) {
        velocity += speed * 5;
        if (velocity > maxSpeed) {
            velocity = maxSpeed;
        }
        System.out.println(carName + "의 현재 속도는 " + velocity + " 입니다.");
    }

    @Override
    void speedDown(int speed) {
        velocity -= speed * 5;
        if (velocity < minSpeed) {
            velocity = minSpeed;
            System.out.println(carName + "의 최저속도 위반으로 속도를 " + velocity + "으로 올립니다.");
        }
    }

    @Override
    void infoCurrentVelocity() {
        System.out.println(carName + "의 현재 속도는 " + velocity + " 입니다.");
    }

    Truck() {

    }

    Truck(String carName, int velocity, int wheelNumber) {
        this.carName = carName;
        this.velocity = velocity;
        this.truckWheel = wheelNumber;
    }
}
