package assignment.abstractclass.prob3.prob1;

public class Tea extends Beverage {
    static int teaAmount;

    public Tea(String name) {
        super(name);
    }

    @Override
    public void calcPrice() {
        switch (super.getName()) {
            case "lemonTea" -> price = 1500;
            case "ginsengTea" -> price = 2000;
            case "redginsengTea" -> price = 2500;
        }
        total += price;
        teaAmount++;
        amount++;
    }

    static void printTea() {
        System.out.println("Tea의 판매 개수=>" + teaAmount + "잔");
    }
}
