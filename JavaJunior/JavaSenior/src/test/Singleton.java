package test;

/**
 * Created by alpha on 16-7-19.
 */
public class Singleton {

    /**
     * 创建单例模式
     * 使用private修饰构造方法，通过getInstance()方法进行创建
     * 使用static修饰getInstance()方法构造只在加载该类的时候执行
     * 使用一个成员变量缓存已经创建的对象
     */
    private static Singleton singleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
