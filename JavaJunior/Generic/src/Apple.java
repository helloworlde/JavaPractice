/**
 * Created by alpha on 16-8-2.
 * 定义类时使用泛型声明
 */
public class Apple<T> {
    private T info;

    public Apple() {

    }

    public Apple(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
