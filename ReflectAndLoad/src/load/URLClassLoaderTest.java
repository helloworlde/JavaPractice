package load;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by alpha on 16-8-23.
 * 通过类加载方式获取JDBC连接
 */
public class URLClassLoaderTest {
    private static Connection connection;

    public static Connection getConn(String url, String user, String pass) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        if (connection == null) {
            URL[] urls = {new URL("file:mysql-connector-java-5.1.35-bin.jar")};
            URLClassLoader myClassLoader = new URLClassLoader(urls);
            Driver driver = (Driver) myClassLoader.loadClass("com.mysql.jdbc.Driver").newInstance();
            Properties properties = new Properties();
            properties.setProperty("user", user);
            properties.setProperty("password", pass);
            connection = driver.connect(url, properties);
        }
        return connection;
    }
}
