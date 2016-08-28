package rowset;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.SQLException;

/**
 * Created by alpha on 16-8-17.
 * RowSetFactory
 */
public class RowSetFactoryTest {
    String url = "jdbc:mysql://localhost:3306/ubuntu";
    public void update(String sql) throws SQLException {
        RowSetFactory factory = RowSetProvider.newFactory();
        try (JdbcRowSet jdbcRowSet = factory.createJdbcRowSet()){
            jdbcRowSet.setUrl(url);
            jdbcRowSet.setUsername("root");
            jdbcRowSet.setPassword("123456");

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
