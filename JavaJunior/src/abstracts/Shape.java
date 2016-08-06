package abstracts;

/**
 * Created by alpha on 16-7-15.
 */
public abstract class Shape {
    protected double length;
    protected double height;

    Shape(final double num, final double num1) {
        length = num;
        height = num1;
    }

    public abstract double area();


}
