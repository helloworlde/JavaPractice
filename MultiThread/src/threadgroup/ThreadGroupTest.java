package threadgroup;

/**
 * Created by alpha on 16-8-12.
 * 线程组
 */
public class ThreadGroupTest {
    public static void test() {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程的名字：" + mainGroup.getName());
        System.out.println("主线程是否后台线程组：" + mainGroup.isDaemon());
        new MyThread("主线程组的线程").start();

        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg是否是后台线程组：" + tg.isDaemon());
        MyThread ttt = new MyThread(tg, "tg的线程组A");
        ttt.start();
        new MyThread(tg, "tg的线程组B").start();
    }
}
