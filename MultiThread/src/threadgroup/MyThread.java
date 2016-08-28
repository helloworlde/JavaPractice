package threadgroup;

/**
 * Created by alpha on 16-8-12.
 */
public class MyThread extends Thread{
    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName()+" 线程的i变量："+i);
        }
    }
}
