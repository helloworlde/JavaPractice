import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by alpha on 16-8-2.
 * 定义泛型方法
 */
public class GenericMethodTest<S> {
    static <T> void fromArrayToCollection(T[] a, Collection<T> collection) {
        for (T o : a) {
            collection.add(o);
        }
    }

    public static void test() {
        Object[] oa = new Object[100];
        Collection<Object> co = new ArrayList<>();
        fromArrayToCollection(oa, co);

        String[] sa = new String[100];
        Collection<String> cs = new ArrayList<>();
        fromArrayToCollection(sa, cs);

        fromArrayToCollection(sa, co);

        Integer[] ia = new Integer[100];
        Float[] fa = new Float[100];
        Number[] na = new Number[100];
        Collection<Number> cn = new ArrayList<>();

        fromArrayToCollection(ia, cn);
        fromArrayToCollection(fa, cn);
        fromArrayToCollection(na, cn);
        fromArrayToCollection(na, co);
//        fromArrayToCollection(na, cs);
    }
}
