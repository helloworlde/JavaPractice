package executesql;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.*;

/**
 * Created by alpha on 16-8-15.
 * 对数据库执行操作
 */
public class ExecuteSQL {
    public void executeSql(String sql) throws SQLException, IOException, ClassNotFoundException {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             Statement statement = conn.createStatement()) {
            boolean hasResultSet = statement.execute(sql);
            if (hasResultSet) {
                try (ResultSet set = statement.getResultSet()) {
                    ResultSetMetaData metaData = set.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    while (set.next()) {
                        for (int i = 0; i < columnCount; i++) {
                            System.out.println(set.getString(i + 1) + "\t");
                        }
                        System.out.println("\n");
                    }
                }
            } else {
                System.out.println("受影响的记录有"+statement.getUpdateCount()+"条");
            }
        }
    }
}
