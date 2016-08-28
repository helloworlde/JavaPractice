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
 * 分页功能实现
 */
public class CachedRowSetPage {
    public CachedRowSet query(String sql,int pageSize,int page) {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            RowSetFactory factory = RowSetProvider.newFactory();
            CachedRowSet cachedRowSet = factory.createCachedRowSet();

            cachedRowSet.setPageSize(pageSize);
            cachedRowSet.populate(resultSet, (page - 1) * pageSize + 1);

            return cachedRowSet;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
