package assignment.abstractclass.prob2;

public class Circle extends Shape{
    private double radius;

    Circle() {

    }

    Circle(double radius) {
        setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculationArea() {
        this.area = Math.pow(getRadius(), 2) * Math.PI;
    }
    @Override
    void print() {
        calculationArea();
        System.out.println("원의 면적은 " + this.area);
    }
}
