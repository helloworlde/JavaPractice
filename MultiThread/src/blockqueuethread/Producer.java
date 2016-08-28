package blockqueuethread;

import java.util.concurrent.BlockingQueue;

/**
 * Created by alpha on 16-8-11.
 * 使用队列阻塞线程
 */
public class Producer extends Thread{
    private BlockingQueue<String> bq;

    public Producer(BlockingQueue<String> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        String[] strArr = new String[]{
                "Java",
                "Struts",
                "Spring"
        };

        for (int i = 0; i < 9999; i++) {
            System.out.println(getName()+"生产者准备生产元素集合");
            try {
                Thread.sleep(200);
                bq.put(strArr[i%3]);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(getName()+"生产完成："+bq);
            }

        }
    }
}
