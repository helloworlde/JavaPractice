package rowset;

import conn.ConnMySQL;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by alpha on 16-8-17.
 * Rowset 可以离线缓存数据
 */
public class CachedRowSetTest {
    public CachedRowSet query(String sql) throws SQLException, IOException, ClassNotFoundException {
        Connection conn = ConnMySQL.getConnection("mysql.ini");
        Statement statement = conn.createStatement();
        ResultSet set = statement.executeQuery(sql);

        RowSetFactory factory = RowSetProvider.newFactory();
        CachedRowSet cachedRowSet = factory.createCachedRowSet();
        cachedRowSet.populate(set);

        set.close();
        statement.close();
        conn.close();
        return cachedRowSet;
    }

    public static void test() throws SQLException, IOException, ClassNotFoundException {
        CachedRowSetTest cachedRowSetTest = new CachedRowSetTest();
        CachedRowSet rowSet = cachedRowSetTest.query("select * from my_test");
        rowSet.afterLast();
        while (rowSet.previous()) {
            System.out.println(rowSet.getString(1) + "\t" + rowSet.getString(2) + "\t" + rowSet.getString(3));
            if (rowSet.getInt("id") == 1) {
                rowSet.updateString("name", "Ying");
                rowSet.updateRow();
            }
        }
        //用于将数据从离线的Rowset中提交到数据库
        Connection connection = ConnMySQL.getConnection("mysql.ini");
        connection.setAutoCommit(false);
        rowSet.acceptChanges(connection);
    }
}
