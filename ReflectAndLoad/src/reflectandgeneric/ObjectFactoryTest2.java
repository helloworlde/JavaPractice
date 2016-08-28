package reflectandgenice;

/**
 * Created by alpha on 16-8-25.
 */
public class ObjectFactoryTest2 {
    public static <T> T getInstace(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
