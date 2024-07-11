package assignment.abstractclass.prob1;

abstract class Wheeler {
    protected int velocity;
    protected String carName;

    abstract void countWheel();
    abstract void speedUp(int speed);
    abstract void speedDown(int speed);

    abstract void infoCurrentVelocity();

    void stop() {
        System.out.println("정지상태로 속도를 0으로 초기화합니다.");
    }
}
