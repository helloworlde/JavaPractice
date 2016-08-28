package proxytest;

/**
 * Created by alpha on 16-8-25.
 */
public class GunDog implements Dog {
    @Override
    public void info() {
        System.out.println("This is a dog");
    }

    @Override
    public void run() {
        System.out.println("run fast");
    }
}
