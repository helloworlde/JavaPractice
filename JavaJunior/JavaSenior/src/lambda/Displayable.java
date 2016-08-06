package lambda;

/**
 * Created by alpha on 16-7-21.
 */
public interface Displayable {
    void display();

    default int add(int a, int b) {
        return a + b;
    }
}
