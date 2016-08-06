package map;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by alpha on 16-8-1.
 */
public class CollectionsTest {
    public void test() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        arrayList.add(4);
        arrayList.add(20);
        arrayList.add(33);
        System.out.println(arrayList);
        Collections.reverse(arrayList);
        System.out.println(arrayList);
        Collections.sort(arrayList);
        System.out.println(arrayList);
        Collections.shuffle(arrayList);
        System.out.println(arrayList);
        System.out.println(Collections.max(arrayList));
        System.out.println(Collections.min(arrayList));
        Collections.replaceAll(arrayList, 0, 1);
        System.out.println(arrayList);
        System.out.println(Collections.frequency(arrayList, 33));
        Collections.sort(arrayList);
        System.out.println(Collections.binarySearch(arrayList, 3));
    }
}
