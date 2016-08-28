package createobj;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by alpha on 16-8-24.
 * 使用反射来创建一个JFrame对象，使用指定的构造器
 */
public class CreateJFrame {
    public static void test() throws NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> clazz = Class.forName("javax.swing.JFrame");
        Constructor constructor = clazz.getConstructor(String.class);
        Object obj = constructor.newInstance("测试窗口");
        System.out.println(obj);
        JFrame jFrame = (JFrame) obj;
        jFrame.setVisible(true);
    }
}
