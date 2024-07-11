package assignment.abstractclass.prob3.prob1;

public class CoffeeShop {
    public static void main(String[] args) {
        System.out.println("****java nara CoffeeShop 영업개시****");

        Beverage bv1 = new Coffee("Cappuccino");
        Beverage bv2 = new Coffee("CafeLatte");
        Beverage bv3 = new Tea("ginsengTea");
        Beverage bv4 = new Coffee("CafeLatte");
        Beverage bv5 = new Tea("redginsengTea");

        Beverage.printTotal();
        Coffee.printCoffee();
        Tea.printTea();
    }
}
