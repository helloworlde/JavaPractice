/**
 * Created by alpha on 16-8-2.
 * 泛型方法
 */
public class GenericDiamondTest<E> {
    public <T> GenericDiamondTest(T t) {
        System.out.println(t);
    }

    public static void test() {
//        GenericMethodTest<String> g1 = new GenericDiamondTest<>(5);
        GenericDiamondTest<String> g2 = new <Integer>GenericDiamondTest<String>(5);
    }
}
