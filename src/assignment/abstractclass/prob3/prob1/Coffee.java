package assignment.abstractclass.prob3.prob1;

public class Coffee extends Beverage{

    static int coffeeAmount;

    Coffee() {

    }
    public Coffee(String name) {
        super(name);
    }

    @Override
    public void calcPrice() {
        switch (super.getName()) {
            case "Americano" -> price = 1500;
            case "CafeLatte" -> price = 2500;
            case "Cappuccino" -> price = 3000;
        }
        total += price;
        coffeeAmount++;
        amount++;
    }
    static void printCoffee() {
        System.out.println("Coffee의 판매 개수=>" + coffeeAmount + "잔");
    }
}
