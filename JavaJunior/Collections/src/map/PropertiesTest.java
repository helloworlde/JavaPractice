package map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by alpha on 16-8-1.
 */
public class PropertiesTest {
    public void test() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("username", "HelloWood");
        properties.setProperty("password", "123456");
        properties.store(new FileOutputStream("a.ini"), "comment line");
        Properties properties1 = new Properties();
        properties1.setProperty("gender", "male");
        properties1.load(new FileInputStream("a.ini"));
        System.out.println(properties1);
    }
}
