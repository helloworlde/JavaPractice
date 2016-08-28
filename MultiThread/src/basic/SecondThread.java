package basic;

/**
 * Created by alpha on 16-8-10.
 */
public class SecondThread implements Runnable {
    private int i;

    @Override
    public void run() {
        for (;i<100;i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
        }
    }
}
