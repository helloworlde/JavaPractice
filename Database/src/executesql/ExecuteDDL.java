package executesql;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by alpha on 16-8-15.
 * 执行数据库定义语言
 */
public class ExecuteDDL {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws FileNotFoundException {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(paramFile));
            driver = properties.getProperty("driver");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            pass = properties.getProperty("pass");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createTable(String sql) {
        try {
            Class.forName(driver);
            try (Connection conn = DriverManager.getConnection(url, user, pass);
                 Statement statement = conn.createStatement()) {
                statement.execute(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
