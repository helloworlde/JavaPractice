package transanction;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.*;

/**
 * Created by alpha on 16-8-18.
 * 查询数据库表的信息
 */
public class DatabaseDataTest {
    public static void info() {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini")){

            DatabaseMetaData databaseMetaData = conn.getMetaData();
            ResultSet rs = databaseMetaData.getTableTypes();
            System.out.println("-----MySQL支持的表类型信息------");
            printResultSet(rs);

            rs = databaseMetaData.getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("------当前数据库里的数据表信息------");
            printResultSet(rs);

            rs = databaseMetaData.getPrimaryKeys(null, null, "my_test");
            System.out.println("-------主键信息----------");
            printResultSet(rs);

            rs = databaseMetaData.getProcedures(null, null, "%");
            System.out.println("------存储过程信息---------");
            printResultSet(rs);

            rs = databaseMetaData.getColumns(null, null, "my_test", "%");
            System.out.println("------数据列--------");


            printResultSet(rs);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData resultSetMetaData = rs.getMetaData();
        for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
            System.out.print(resultSetMetaData.getColumnName(i+1)+"\t");
        }
        System.out.println();

        while (rs.next()) {
            for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                System.out.print(rs.getString(i+1)+"\t");
            }
            System.out.println();
        }
        rs.close();
    }
}
