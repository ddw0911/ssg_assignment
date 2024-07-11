package assignment.abstractclass.prob3.prob1;

public abstract class Beverage {
    private String name;
    protected int price;
    static int amount;

    static int total;


    public Beverage() {

    }

    public Beverage(String name) {
        setName(name);
        calcPrice();
        print();
    }

    public abstract void calcPrice();

    void print() {
        System.out.println(amount + "번째 판매 음료는 " + getName() + "이며, 가격은 " + price);
    }

    static void printTotal() {
        System.out.println("총 판매 금액==>" + total);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
