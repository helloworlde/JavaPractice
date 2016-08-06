import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by alpha on 16-8-2.
 * 泛型菱形语法
 */
public class DiamandTest {
    public static void diamandTest() {
        List<String> books = new ArrayList<>();
        books.add("java");
        books.add("ios");
        books.forEach(str -> System.out.println(str));

        Map<String, List<String>> schoolInfo = new HashMap<>();
        List<String> schools = new ArrayList<>();
        schools.add("LGD");
        schools.add("LJD");
        schools.add("DLLG");
        schoolInfo.put("School", schools);
        schoolInfo.forEach((key, value) -> System.out.println(key + "--" + value));
    }
}
