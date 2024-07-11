package assignment.abstractclass.prob2;

public class TestShape {
    public static void main(String[] args) {
        Shape circle = new Circle(10);
        Shape rectangle = new Rectangular(20, "10");

//        circle.calculationArea();
//        rectangle.calculationArea();

        circle.print(); // 314.1592
        rectangle.print(); // 200.0
    }
}
