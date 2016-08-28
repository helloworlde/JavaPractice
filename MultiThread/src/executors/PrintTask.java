package executors;

import java.util.concurrent.RecursiveAction;

/**
 * Created by alpha on 16-8-12.
 * 线程池多线程输出
 */
public class PrintTask extends RecursiveAction {

    private static final int THRESHOLD = 50;
    private int start;
    private int end;

    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + "i的值：" + i);
            }
        } else {
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            left.fork();
            right.fork();
        }
    }
}
