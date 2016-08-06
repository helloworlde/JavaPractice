package abstracts;

/**
 * Created by alpha on 16-7-15.
 */
public class Square extends Shape {
    public Square(double num, double num1) {
        super(num, num1);
    }

    @Override
    public double area() {
        System.out.println("正方形的面积为：");
        return length * height;
    }
}
