package assignment.interface_.Q2;

public class CarFactory extends Factory implements WorkingTogether{
    public CarFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        int result;
        switch (skill) {
            case 'A' -> result = 3 * getWorkingTime();
            case 'B' -> result = 2 * getWorkingTime();
            case 'C' -> result = 1 * getWorkingTime();
            default -> result = 0;
        }
        return result;
    }

    @Override
    public int workTogether(WorkingTogether partner) {
        return this.makeProducts('B');
    }
}
