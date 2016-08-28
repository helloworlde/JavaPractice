package basic;

/**
 * Created by alpha on 16-8-10.
 */
public class FirstThread extends Thread {
    private int i;

    @Override
    public void run() {
        for (;i<100;i++) {
            System.out.println(getName()+" "+i);
        }
    }
}
