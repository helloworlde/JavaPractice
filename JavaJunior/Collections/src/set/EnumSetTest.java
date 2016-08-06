package set;

import java.util.EnumSet;

/**
 * Created by alpha on 16-7-31.
 * 枚举类集合类
 */

enum Season {
    SPRING, SUMMER, FALL, WINTER
}

public class EnumSetTest {
    public void enumTest() {
        EnumSet e1 = EnumSet.allOf(Season.class);
        System.out.println(e1);
        EnumSet e2 = EnumSet.noneOf(Season.class);
        System.out.println(e2);
        e2.add(Season.WINTER);
        e2.add(Season.SPRING);
        System.out.println(e2);
        EnumSet e3 = EnumSet.of(Season.SUMMER, Season.WINTER);
        System.out.println(e3);
        EnumSet e4 = EnumSet.range(Season.SUMMER, Season.WINTER);
        System.out.println(e4);
        EnumSet e5 = EnumSet.complementOf(e4);
        System.out.println(e5);
    }
}
