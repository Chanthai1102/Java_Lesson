package OOP.Polymorphism;

public class Circle extends Shape{
    private double r ;

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        return Math.PI * r * r;
    }

    @Override
    String getType() {
        return "Circle";
    }
}
