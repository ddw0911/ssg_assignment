package assignment.interface_.Q2;

public abstract class Factory {
    int openHour;
    int closeHour;
    String name;

    Factory() {

    }

    public Factory(String name, int openHour, int closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.name = name;
    }

    String getFactoryName() {
        return name;
    }

    int getWorkingTime() {
        return closeHour - openHour;
    }

    abstract int makeProducts(char skill);
}
