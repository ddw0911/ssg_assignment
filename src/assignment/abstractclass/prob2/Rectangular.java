package assignment.abstractclass.prob2;

public class Rectangular extends Shape{
    private double width;
    private String height;

    Rectangular() {

    }

    Rectangular(double width, String height) {
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    @Override
    public void calculationArea() {
        this.area = getWidth() * Double.parseDouble(getHeight());
    }

    @Override
    void print() {
        calculationArea();
        System.out.println("직사각형의 면적은 " + this.area);
    }
}
