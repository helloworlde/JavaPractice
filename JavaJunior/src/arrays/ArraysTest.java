package arrays;

import java.util.Arrays;

/**
 * Created by alpha on 16-7-18.
 */
public class ArraysTest {
    int[] a = new int[]{3, 4, 5, 6};
    int[] b = new int[]{3, 4, 5, 6};

    public void arraysMethod() {
        System.out.println("a == b?" + Arrays.equals(a, b));
        int[] c = Arrays.copyOf(a, 6);
        System.out.println("c:" + Arrays.toString(c));
        Arrays.fill(c, 2, 4, 1);
        System.out.println("c:" + Arrays.toString(c));
        Arrays.sort(b);
        System.out.println("b:" + Arrays.toString(b));
    }

}
