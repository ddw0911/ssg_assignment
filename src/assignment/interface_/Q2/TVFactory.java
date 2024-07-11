package assignment.interface_.Q2;

public class TVFactory extends Factory implements WorkingTogether{

    public TVFactory(String name, int openHour, int closeHour) {
        super(name, openHour, closeHour);
    }

    @Override
    int makeProducts(char skill) {
        int result;
        switch (skill) {
            case 'A' -> result = 8 * getWorkingTime();
            case 'B' -> result = 5 * getWorkingTime();
            case 'C' -> result = 3 * getWorkingTime();
            default -> result = 1 * getWorkingTime();
        }
        return result;
    }

    @Override
    public int workTogether(WorkingTogether partner) {
        return this.makeProducts('C');
    }
}
