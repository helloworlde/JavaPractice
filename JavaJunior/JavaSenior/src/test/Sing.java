package test;

/**
 * Created by alpha on 16-7-19.
 */
public class Sing {
    private static Sing ourInstance = new Sing();

    private Sing() {
        System.out.println("构造方法执行了");
    }

    public static Sing getInstance() {
        System.out.println("getInstance执行了");
        System.out.println(ourInstance);
        return ourInstance;
    }
}
