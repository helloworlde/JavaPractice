package executesql;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by alpha on 16-8-16.
 * 管理结果集
 */
public class ResultSetTest {
    public void query(String sql) {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             PreparedStatement statement = conn.prepareStatement(sql,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_UPDATABLE);
             ResultSet rs = statement.executeQuery()) {
            rs.last();
            int rowCount = rs.getRow();
            for (int i = rowCount; i > 0; i--) {
                System.out.println(rs.getString(1) + "\t" + rs.getString(2)+ "\t" + rs.getString(3));
                rs.absolute(i);
                rs.updateString(2,"哈哈哈" + i);
                rs.updateRow();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
