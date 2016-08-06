import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpha on 16-8-2.
 * 创建集合时指定元素类型
 */
public class GenericList {
    public void genericTest() {
        List<String> stringList = new ArrayList<>();
        stringList.add("Java");
        stringList.add("Android");
//        stringList.add(4);
        stringList.forEach(str -> System.out.println(str));
    }
}
