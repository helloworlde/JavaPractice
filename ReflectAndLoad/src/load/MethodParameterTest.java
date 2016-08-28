package load;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.List;

/**
 * Created by alpha on 16-8-23.
 */

class Test {
    public void replace(String str, List<String> list) {

    }
}

public class MethodParameterTest {
    public static void test() throws NoSuchMethodException {
        Class<Test> clazz = Test.class;
        Method replace = clazz.getMethod("replace", String.class, List.class);
        System.out.println("replace的参数个数：" + replace.getParameterCount());

        Parameter[] parameters = replace.getParameters();
        int index = 1;

        for (Parameter p : parameters) {
            if (p.isNamePresent()) {
                System.out.println("----第" + index++ + "个参数-----");
                System.out.println("参数名：" + p.getName());
                System.out.println("形参类型：" + p.getType());
                System.out.println("泛型类型：" + p.getParameterizedType());
            }
        }
    }
}
