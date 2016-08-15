package conn;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Created by alpha on 16-8-15.
 */
public class ExcuteDML {
    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(paramFile));

        driver = properties.getProperty("driver");
        url = properties.getProperty("url");
        user = properties.getProperty("user");
        pass = properties.getProperty("pass");
    }

    public int insertData(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try (Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql);
        }
    }


}
