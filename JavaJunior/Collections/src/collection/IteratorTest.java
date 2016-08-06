package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by alpha on 16-7-31.
 * 使用Iterator迭代器
 */
public class IteratorTest {
    public void iterator() {
        Collection collection = new ArrayList();
        collection.add("哈哈哈哈");
        collection.add("哈哈哈哈1");
        collection.add("哈哈哈哈2");
        collection.add("哈哈哈哈3");
        collection.add("哈哈哈哈4");
        collection.add("哈哈哈哈5");
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            System.out.println(str);
        }
    }


}
