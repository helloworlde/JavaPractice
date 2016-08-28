package basic;

/**
 * Created by alpha on 16-8-12.
 * ThreadLocal 线程局部变量
 */
public class ThreadLocalTest extends Thread{
    private Account account;

    public ThreadLocalTest(String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName()+"账户的i值："+i);
        }
    }
}
