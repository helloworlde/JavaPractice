package executesql;

import conn.ConnMySQL;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Created by alpha on 16-8-16.
 * 调用存储过程
 */
public class CallableStatementTest {
    public void callProcedure() {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             CallableStatement callableStatement = conn.prepareCall("{call add_pro(?,?,?)}")) {
            callableStatement.setInt(1, 4);
            callableStatement.setInt(2, 5);

            callableStatement.registerOutParameter(3, Types.INTEGER);
            callableStatement.execute();
            System.out.println("执行结果是："+callableStatement.getInt(3));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
