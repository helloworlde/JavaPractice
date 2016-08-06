package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

/**
 * Created by alpha on 16-7-31.
 * 使用Predicate操作集合
 * 统计字符串出现的次数
 */
public class PredicateTest {
    public static int calAll(Collection collection, Predicate predicate) {
        int total = 0;
        for (Object obj : collection) {
            if (predicate.test(obj)) {
                total++;
            }
        }

        return total;
    }

    public void calculator() {
        Collection collection = new ArrayList();
        collection.add("哈哈哈哈");
        collection.add("哈java哈1");
        collection.add("哈Android哈2");
        collection.add("哈java3");
        collection.add("哈javajavajava哈4");
        collection.add("哈哈哈哈哈哈哈哈哈5");
        System.out.println(calAll(collection, ele -> ((String) ele).contains("哈哈")));
        System.out.println(calAll(collection, ele -> ((String) ele).contains("java")));
        System.out.println(calAll(collection, ele -> ((String) ele).length() > 7));
    }
}
