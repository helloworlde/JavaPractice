package test;

/**
 * Created by alpha on 16-7-19.
 */
public class UnsignedTest {
    public UnsignedTest() {
        byte b = (byte) -3;
        System.out.println("byte类型的-3对应的无符号整数：" + Byte.toUnsignedInt(b));
        int val = Integer.parseUnsignedInt("ab", 16);
        System.out.println(val);

        System.out.println(Integer.toUnsignedString(-12, 16));

        System.out.println(Integer.divideUnsigned(-2, 3));

        System.out.println(Integer.remainderUnsigned(-2, 7));
    }
}
