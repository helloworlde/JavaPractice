package shape;

/**
 * Created by alpha on 16-7-19.
 */
public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        super(color);
        this.setSide(a, b, c);

    }

    private void setSide(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.out.println("三角形两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "三角形";
    }
}
