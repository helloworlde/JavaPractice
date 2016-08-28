package load;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * Created by alpha on 16-8-23.
 * 访问JVM类加载器
 */
public class ClassLoaderPropTest {
    public static void test() {

        try {
            ClassLoader systemLoader = ClassLoader.getSystemClassLoader();
            System.out.println("系统类加载器："+systemLoader);
            Enumeration<URL> em1 = systemLoader.getResources("");
            while (em1.hasMoreElements()) {
                System.out.println(em1.nextElement());
            }

            ClassLoader extensionLader = systemLoader.getParent();
            System.out.println("扩展类加载器："+extensionLader);
            System.out.println("扩展类加载器的加载路径："+System.getProperty("java.ext.dirs"));
            System.out.println("扩展类加载器的Parent：" + extensionLader.getParent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
