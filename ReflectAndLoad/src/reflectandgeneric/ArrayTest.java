package reflectandgeneric;

import java.lang.reflect.Array;

/**
 * Created by alpha on 16-8-25.
 */
public class ArrayTest {
    public static <T> T[] newInstance(Class<T> componentType, int length) {
        return (T[]) Array.newInstance(componentType, length);
    }

    public static void test() {
        String[] arr = ArrayTest.newInstance(String.class, 10);
        int[][] intArr = ArrayTest.newInstance(int[].class, 5);
        arr[5] = "Java";
        intArr[1] = new int[]{23, 12};
        System.out.println(arr[5]);
        System.out.println(intArr[1][1]);
    }
}
