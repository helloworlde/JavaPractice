package unit5;

/**
 * Created by alpha on 16-7-18.
 */
public class Param {
    int a = 3;
    int b = 4;

    public void source() {
        System.out.println("source--a:" + a + "\tb:" + b);
        swap(a, b);
    }

    private void swap(int c, int d) {
        int temp = 0;
        temp = a;
        a = b;
        b = temp;
        System.out.println("swap--a:" + a + "\tb:" + b);
    }


}
