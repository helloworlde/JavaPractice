package map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alpha on 16-8-1.
 */
public class MapTest {
    public void test() {
        Map map = new HashMap();
        map.put(null, null);
        System.out.println(map.put(null, null));
        map.put("Java", 13);
        map.put("ios", 2);
        map.put("Android", 4);
        map.put("xmarin", 66);
        System.out.println(map.toString());
        System.out.println(map.put("ios", 333));
        System.out.println(map);
        System.out.println(map.containsKey("Java"));
        System.out.println(map.containsValue(13));
        for (Object key :
                map.keySet()
                ) {
            System.out.println(key + "---" + map.get(key));
        }
        map.remove("ios");
        System.out.println(map);


    }
}
