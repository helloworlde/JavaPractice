package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 16-7-31.
 */

class A {
    @Override
    public boolean equals(Object obj) {
        return true;
    }
}

public class ListTest2 {
    public void listTest2() {
        List books = new ArrayList();
        books.add("Java EE");
        books.add("Java ME");
        books.add("Java SE");
        System.out.println(books);
        books.remove(new A());
        System.out.println(books);
        books.remove(new A());
        System.out.println(books);
    }
}
