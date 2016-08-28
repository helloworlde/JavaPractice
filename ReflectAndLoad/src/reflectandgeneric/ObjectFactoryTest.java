package reflectandgeneric;

/**
 * Created by alpha on 16-8-25.
 * 未使用泛型
 */
public class ObjectFactoryTest {
    public static Object getInstance(String clsName) {
        try {
            Class cls = Class.forName(clsName);
            return cls.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
