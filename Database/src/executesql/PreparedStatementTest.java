package executesql;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alpha on 16-8-16.
 * 使用Statement和PreparedStatement
 */
public class PreparedStatementTest {
    public void insertUseStatement() {
        long start = System.currentTimeMillis();
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             Statement statement = conn.createStatement()) {
            for (int i = 0; i < 100; i++) {
                statement.executeUpdate("insert into my_test VALUES(NULL,'姓名" + i + "')");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("使用Statement用时：" + (System.currentTimeMillis() - start));
    }

    public void insertUsePrepare() {
        long start = System.currentTimeMillis();
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO my_test values(null,?)")) {
            for (int i = 0; i < 100; i++) {
                preparedStatement.setString(1, "姓名：" + i);
                preparedStatement.executeUpdate();
            }
            System.out.println("使用PreparedStatement用时：" + (System.currentTimeMillis() - start));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
