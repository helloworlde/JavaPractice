package shape;

/**
 * Created by alpha on 16-7-19.
 */
public class Circle extends Shape {

    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double calPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getType() {
        return getColor() + "圆形";
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
