import basic.Account;
import basic.ThreadLocalTest;

import java.util.concurrent.ExecutionException;

/**
 * Created by alpha on 16-8-10.
 */
public class MainMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //调用FirstThread，继承Thread类
        /*for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " "+i);
            if (i == 20) {
                new FirstThread().start();
                new FirstThread().start();
            }
        }*/

        //调用SecondThread,实现runnable接口
       /* for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " "+i);
            if (i == 20) {
                SecondThread secondThread = new SecondThread();
                new Thread(secondThread,"新线程1").start();
                new Thread(secondThread,"新线程2").start();
            }
        }*/

       //调用Callable接口
        /*FutureTask<Integer> task = new FutureTask<Integer>((Callable<Integer>)()->{
            int i = 0;
            for (;i<100;i++) {
                System.out.println(Thread.currentThread().getName()+"的i的值："+i);
            }
            return i;
        });

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" 的i的值："+i);
            if (i == 20) {
                new Thread(task,"有返回值的线程").start();
            }
        }

        System.out.println("子线程的返回值："+task.get());*/

        /*new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread joinThread = new JoinThread("被加入的线程");
                joinThread.start();
                joinThread.join();
            }
            System.out.println(Thread.currentThread().getName()+" "+i);
        }*/

        /*Account account = new Account("123456", 1000);
        new DrawThread("A",account,800).start();
        new DrawThread("B",account,800).start();*/

        /*Account account = new Account("12345678", 0);
        new DrawThread("取钱者",account,800).start();
        new DepositThread("A",account,800).start();
        new DepositThread("B",account,800).start();
        new DepositThread("C",account,800).start();*/

        /*BlockingQueue<String> bq = new ArrayBlockingQueue<>(1);
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        new Consumer(bq).start();*/

//        ThreadGroupTest.test();
//        ExceptionTest.test();
//        ThreadPoolTest.test();

        /*ForkJoinPool pool = new ForkJoinPool();
        pool.submit(new PrintTask(0, 300));
        pool.awaitTermination(2, TimeUnit.SECONDS);
        pool.shutdown();*/

        /*int[] arr = new int[100];
        Random random = new Random();
        int total = 0;
        for (int i = 0, len = arr.length; i < len; i++) {
            int tmp = random.nextInt(20);
            total += (arr[i] = tmp);
        }
        System.out.println(total);
        ForkJoinPool pool = ForkJoinPool.commonPool();
        Future<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
        System.out.println(future.get());
        pool.shutdown();*/


        Account account = new Account("初始名");
        new ThreadLocalTest("A",account).start();
        new ThreadLocalTest("B",account).start();
    }
}
