package OOP.Polymorphism;

public abstract class Shape {
    abstract double getArea();
    abstract String getType();

    public void display(){
        System.out.println("Type : " + getType() + " Area : " + getArea());
    }
}
