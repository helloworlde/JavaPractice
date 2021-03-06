package blockqueuethread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by alpha on 16-8-11.
 * 使用队列阻塞线程
 */
public class Consumer extends Thread {
    private BlockingQueue<String> bq;

    public Consumer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(getName()+"消费者准备消费集合元素！");
            try {
                Thread.sleep(200);
                bq.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(getName()+"消费完成"+bq);
            }
        }
    }
}
