package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by alpha on 16-7-31.
 * Collection子类
 */
public class CollectionTest {

    public void collectionTest() {
        Collection arrayList = new ArrayList();
        arrayList.add("孙悟空");
        arrayList.add(6);//自动装箱
        System.out.println("arrayList集合元素个数" + arrayList.size());
        arrayList.remove(6);
        System.out.println("arrayList集合元素个数" + arrayList.size());
        System.out.println("arrayList是否包含\"孙悟空\"" + arrayList.contains("孙悟空"));
        arrayList.add("java");
        System.out.println("arrayList包含元素" + arrayList);
        Collection hashSet = new HashSet();
        hashSet.add("JavaScript");
        hashSet.add("Android");
        hashSet.add("java");
        System.out.println("arrayList是否完全包含hashSet" + arrayList.containsAll(hashSet));
        arrayList.addAll(hashSet);
        System.out.println("arrayList集合元素" + arrayList);
        arrayList.removeAll(hashSet);//用arrayList减去hashSet的元素
        System.out.println("arrayList集合元素" + arrayList);
        arrayList.clear();//删除C中所有元素
        System.out.println("arrayList集合元素" + arrayList);
        hashSet.retainAll(arrayList);//控制hashSet只剩下arrayList也包含的元素
        System.out.println("hashSet元素" + hashSet);
    }

}
