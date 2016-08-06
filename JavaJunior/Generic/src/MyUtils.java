import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by alpha on 16-8-2.
 * 通配符下限
 */
public class MyUtils {
    public static <T> T copy(Collection<? super T> dest, Collection<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            dest.add(ele);
        }
        return last;
    }

    public static void test() {
        List<Number> ln = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        li.add(5);
        Integer last = copy(ln, li);
        System.out.println(ln);
    }
}
