package load;

import sun.misc.Launcher;

import java.net.URL;

/**
 * Created by alpha on 16-8-23.
 * 输出根类加载器
 */
public class BootstrapTest {
    public static void test() {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (int i = 0; i < urls.length; i++) {
            System.out.println(urls[i].toExternalForm());
        }
    }
}
