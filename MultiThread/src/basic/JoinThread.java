package basic;

/**
 * Created by alpha on 16-8-10.
 */
public class JoinThread extends Thread{
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+" "+i);
        }
    }
}
