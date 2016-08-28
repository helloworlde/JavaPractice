package reflectandgeneric;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by alpha on 16-8-25.
 * 获取泛型信息
 */
public class GenericTest {
    private Map<String,Integer> score;

    public static void test() throws NoSuchFieldException {
        Class<GenericTest> clazz = GenericTest.class;
        Field f = clazz.getDeclaredField("score");
        Class<?> a = f.getType();
        System.out.println("score的类型是：" + a);
        Type type = f.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type type1 = parameterizedType.getRawType();
            System.out.println("原始类型：" + type1);
            Type[] types = parameterizedType.getActualTypeArguments();
            System.out.println("泛型信息：");
            for (int i = 0; i < types.length; i++) {
                System.out.println("第" + i + "个泛型类型是：" + types[i]);
            }
        } else {
            System.out.println("获取泛型信息出错");
        }
    }
}
