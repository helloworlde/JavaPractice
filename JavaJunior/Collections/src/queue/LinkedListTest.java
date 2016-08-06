package queue;

import java.util.LinkedList;

/**
 * Created by alpha on 16-8-1.
 * LinkedList作为List,双端队列，栈使用
 */
public class LinkedListTest {
    public void test() {
        LinkedList books = new LinkedList();
        books.offer("Java");
        books.offer("JavaEE");
        System.out.println(books);
        books.push("Android");
        System.out.println(books);
        books.offerFirst("ios");
        System.out.println(books);
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        System.out.println(books.peekFirst());
        System.out.println(books.pop());
        System.out.println(books);
        System.out.println(books.pollLast());
        System.out.println(books);
    }

}
