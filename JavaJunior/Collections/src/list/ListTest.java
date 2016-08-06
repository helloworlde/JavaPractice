package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 16-7-31.
 * List
 */
public class ListTest {
    public void listTest() {
        List books = new ArrayList();
        books.add(new String("Java EE"));
        books.add(new String("Java SE"));
        books.add(new String("Java ME"));
        books.add(new String("Android"));
        System.out.println(books);

        books.add(1, new String("ios"));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        books.remove(2);
        System.out.println(books.indexOf(new String("Android")));
        books.set(1, new String("xarmin"));
        System.out.println(books);
        System.out.println(books.subList(1, 3));
    }
}
