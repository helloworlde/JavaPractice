package transanction;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alpha on 16-8-17.
 * 使用事务
 */
public class TransanctionTest {
    public void insertInTransanction(String[] sqls) {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini")){
            conn.setAutoCommit(false);
            try (Statement statement = conn.createStatement()){
                for (String sql :
                        sqls) {
                    statement.executeUpdate(sql);
                }

            }
            conn.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
