package conn;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * Created by alpha on 16-8-15.
 * 连接数据库
 */
public class ConnMySQL {

    private static String driver;
    private static String url;
    private static String user;
    private static String pass;
    private static Properties config = new Properties();

    public static void testConnect() throws ClassNotFoundException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        try (
                //2.获取连接
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ubuntu", "root", "123456");
                //3.创建对象
                Statement statement = conn.createStatement();
                //4.执行操作
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(String configFile) throws IOException, ClassNotFoundException, SQLException {
        config.load(new FileInputStream(configFile));
        driver = config.getProperty("driver");
        url = config.getProperty("url");
        user = config.getProperty("user");
        pass = config.getProperty("pass");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, pass);
        return connection;
    }
}
