package threadexception;

/**
 * Created by alpha on 16-8-12.
 * 自定义线程异常处理
 */
public class ExceptionTest {
    public static void test() {
        Thread.currentThread().setUncaughtExceptionHandler(new MyExceptionHandler());

        int a = 5/0;
        System.out.println("程序正常结束");
    }
}
