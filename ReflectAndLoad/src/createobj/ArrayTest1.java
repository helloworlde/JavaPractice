package createobj;

import java.lang.reflect.Array;

/**
 * Created by alpha on 16-8-24.
 */
public class ArrayTest1 {
    public static void test() {
        try {
            Object arr = Array.newInstance(String.class, 10);
            Array.set(arr, 5, "Java");
            Array.set(arr, 6, "Android");

            Object book1 = Array.get(arr, 5);
            Object book2 = Array.get(arr, 6);
            System.out.println(book1);
            System.out.println(book2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
