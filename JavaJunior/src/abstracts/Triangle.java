package abstracts;

/**
 * Created by alpha on 16-7-15.
 */
public class Triangle extends Shape {
    public Triangle(double num, double num1) {
        super(num, num1);
    }

    @Override
    public double area() {
        System.out.println("三角形的面积为：");
        return 0.5 * length * height;
    }
}
