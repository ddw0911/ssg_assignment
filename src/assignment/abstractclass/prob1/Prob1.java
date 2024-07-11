package assignment.abstractclass.prob1;

public class Prob1 {
    public static void main(String[] args) {
        Wheeler truck  = new Truck("트럭", 100, 4);
        Wheeler bike  = new Bike("자전거", 25, 2);

        truck.countWheel();
        bike.countWheel();

        truck.infoCurrentVelocity();
        bike.infoCurrentVelocity();

        truck.speedDown(50);
        bike.speedDown(50);

        truck.stop();
        bike.stop();

        truck.infoCurrentVelocity();
    }
}
