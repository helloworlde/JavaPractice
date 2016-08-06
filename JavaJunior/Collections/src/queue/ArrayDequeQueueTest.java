package queue;

import java.util.ArrayDeque;

/**
 * Created by alpha on 16-8-1.
 * ArrayDeque作为队列使用
 */
public class ArrayDequeQueueTest {
    public void test() {
        ArrayDeque queue = new ArrayDeque();
        queue.offer("Java");
        queue.offer("ios");
        queue.offer("Android");
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue);
        System.out.println(queue.poll());
        System.out.println(queue);
    }
}
