package queue;

import java.util.ArrayDeque;

/**
 * Created by alpha on 16-8-1.
 * ArrayDeque作为栈
 */
public class ArrayDequeStackTest {
    public void test() {
        ArrayDeque stack = new ArrayDeque();
        stack.push("java");
        stack.push("Java EE");
        stack.push("Android");
        System.out.println(stack);
        System.out.println(stack.peek());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
    }
}
