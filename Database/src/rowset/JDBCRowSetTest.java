package rowset;

import com.sun.rowset.JdbcRowSetImpl;
import conn.ConnMySQL;

import javax.sql.rowset.JdbcRowSet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alpha on 16-8-17.
 * RowSet
 */
public class JDBCRowSetTest {
    public void update(String sql) {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             JdbcRowSet jdbcRowSet = new JdbcRowSetImpl(conn)) {
            jdbcRowSet.setCommand(sql);
            jdbcRowSet.execute();
            jdbcRowSet.afterLast();
            while (jdbcRowSet.previous()) {
                System.out.println(jdbcRowSet.getString(1) + "\t"
                        + jdbcRowSet.getString(2) + "\t"
                        + jdbcRowSet.getString(3));
                if (jdbcRowSet.getInt("id") == 2) {
                    jdbcRowSet.updateString("name", "Alice");
                    jdbcRowSet.updateRow();
                }
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
