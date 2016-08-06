package shape;

/**
 * Created by alpha on 16-7-19.
 */
public abstract class Shape {
    private String color;

    {
        System.out.println("执行shape的初始化类");
    }

    public Shape() {

    }

    public Shape(String color) {
        System.out.println("执行shape的构造方法");
        this.color = color;
    }

    public abstract double calPerimeter();

    public abstract String getType();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
