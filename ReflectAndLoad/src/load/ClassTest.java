package load;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by alpha on 16-8-23.
 */

@Repeatable(Annos.class)
@interface Anno {
}

@Retention(value = RetentionPolicy.RUNTIME)
@interface Annos {
    Anno[] value();
}

@SuppressWarnings(value = "unchecked")
@Deprecated
@Anno
@Anno
public class ClassTest {
    private ClassTest() {

    }

    public ClassTest(String name){
        System.out.println("执行有参数的info方法");
    }
    public void info() {
        System.out.println("执行无参数的info方法");
    }

    public void info(String string) {
        System.out.println("执行有参数的info方法"+string);
    }

    class Inner {
    }

    public static void test() throws NoSuchMethodException, ClassNotFoundException {
        Class<ClassTest> clazz = ClassTest.class;
        Constructor[] ctors = clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下：");
        for (Constructor c : ctors) {
            System.out.println(c);
        }

        Constructor[] publicCtors = clazz.getConstructors();
        System.out.println("\nClassTest的public方法如下：");
        for (Constructor c : publicCtors) {
            System.out.println(c);
        }

        Method[] mtds = clazz.getMethods();
        System.out.println("\nClassTest的全部public方法如下：");
        for (Method m : mtds) {
            System.out.println(m);
        }

        System.out.println("\nClassTest里带一个字符串参数的info方法："+clazz.getMethod("info",String.class));

        Annotation[] anns = clazz.getAnnotations();
        System.out.println("ClassTest中的Annotation如下：");
        for (Annotation a : anns) {
            System.out.println(a);
        }

        System.out.println("\n该Class元素上的@SuppressWarnings注解为：" + Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
        System.out.println("\n该Class元素上的@Anno注解为："+Arrays.toString(clazz.getAnnotationsByType(Anno.class)));

        Class<?>[] inners = clazz.getDeclaredClasses();
        System.out.println("\nClasssTest的全部内部类如下：");
        for (Class c : inners) {
            System.out.println(c);
        }

        Class inClazz = Class.forName("ClassTest$Inner");
        System.out.println("\ninClazz对应的外部类为："+inClazz.getDeclaredClasses());
        System.out.println("\nClassTest的包为："+clazz.getPackage());
        System.out.println("\nClassTest的父类为："+clazz.getSuperclass());
    }
}
