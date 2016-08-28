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
 */
public class Test {
    public static void test() {
        try {
            Connection conn = ConnMySQL.getConnection("mysql.ini");
            Statement statement = conn.createStatement();
            ResultSet set = statement.executeQuery("SELECT * FROM my_test");


            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet rowSet = factory.createCachedRowSet();
            rowSet.populate(set);
            System.out.println("-------------"+rowSet.size());
            rowSet.afterLast();
            while (rowSet.previous()) {
                System.out.println(rowSet.getString(1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
