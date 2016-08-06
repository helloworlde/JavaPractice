package collection;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by alpha on 16-7-31.
 * Lambda表达式迭代输出元素
 */
public class CollectionForEach {
    public void collectionForEach() {
        Collection collection = new HashSet();
        collection.add("java");
        collection.add("Android");
        collection.add("ios");
        collection.add("C#");
        collection.add("xamrin");
        collection.forEach(obj -> System.out.println("迭代元素" + obj));
    }
}
