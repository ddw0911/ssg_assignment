package assignment.abstractclass.prob3.prob2;

public abstract class Content {
    private String title;
    private int price;

    Content() {

    }

    public Content(String title) {
        setTitle(title);
    }

    abstract void totalPrice();

    void show() {
        System.out.println(title + " 비디오의 가격은 " + price + "원 입니다.");
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
