package createobj;

import java.lang.reflect.Array;

/**
 * Created by alpha on 16-8-24.
 */
public class ArrayTest2 {
    public static void test() {
        Object arr = Array.newInstance(String.class, 3, 4, 10);

        Object arrObj = Array.get(arr, 2);
        Array.set(arrObj, 2, new String[]{"Java", "Java EE"});

        Object anArr = Array.get(arrObj, 3);
        Array.set(anArr, 8, "Android");

        String[][][] cast = (String[][][]) arr;

        System.out.println(cast[2][3][8]);
        System.out.println(cast[2][2][0]);
        System.out.println(cast[2][2][1]);
    }
}
