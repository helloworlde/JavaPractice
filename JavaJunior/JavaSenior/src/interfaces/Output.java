package interfaces;

/**
 * Created by alpha on 16-7-20.
 */
public interface Output {
    int MAX_CACHE_LINE = 50;

    static String staticTest() {
        return "接口里的方法";
    }

    void out();

    void getData(String msg);

    default void print(String... msgs) {
        for (String msg : msgs) {
            System.out.println(msg);
        }
    }

    default void test() {
        System.out.println("默认test()方法");
    }
}
