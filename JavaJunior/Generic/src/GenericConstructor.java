/**
 * Created by alpha on 16-8-2.
 * 泛型构造器
 */
public class GenericConstructor {
    public <T> GenericConstructor(T t) {
        System.out.println(t);
    }

    public static void test() {
        new GenericConstructor("Java");
        new GenericConstructor(200);
        new <String>GenericConstructor("Android");
        new <Integer>GenericConstructor(12);
    }
}
