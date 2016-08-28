package threadexception;

/**
 * Created by alpha on 16-8-12.
 */
public class MyExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t+"出现了异常"+e);
    }
}
