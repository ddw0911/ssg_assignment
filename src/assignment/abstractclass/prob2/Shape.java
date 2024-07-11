package assignment.abstractclass.prob2;

public abstract class Shape {
    protected double area;
    private String name;

    public Shape() {

    }

    public Shape(String name) {
        setName(name);
    }

    public abstract void calculationArea();

    void print() {
        System.out.println(name + "의 면적은 " + area);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
