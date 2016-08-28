import rowset.QueryExecutor;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by alpha on 16-8-15.
 */
public class MainMethod {
    public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
//        ConnMySQL.testConnect();

        /*ExecuteDDL ddl = new ExecuteDDL();
        ddl.initParam("mysql.ini");
        ddl.createTable("create table jdbc_test(id int auto_increment primary key,name varchar(20));");
        System.out.println("建表成功");*/

        /*ExcuteDML dml = new ExcuteDML();
        dml.initParam("mysql.ini");
        int result = dml.insertData("insert into jdbc_test values(1,'HelloWood')");
        System.out.println("----共有"+result+"条记录受影响");*/

       /* ExecuteSQL sql = new ExecuteSQL();
        System.out.println("---------删表DDL----------");
        sql.executeSql("drop table if exists my_test");
        System.out.println("---------建表DDL----------");
        sql.executeSql("create table my_test(id int auto_increment primary key,name varchar(20))");
        System.out.println("---------插入DML----------");
        sql.executeSql("insert into my_test values(1,'hello')");
        System.out.println("---------查询DML----------");
        sql.executeSql("select * from my_test");*/

        /*PreparedStatementTest test = new PreparedStatementTest();
        test.insertUseStatement();
        test.insertUsePrepare();*/

//        new LoginFrame().init();
//        new CallableStatementTest().callProcedure();

        /*ResultSetTest resultSetTest = new ResultSetTest();
        resultSetTest.query("select * from my_test");*/

//        new JDBCRowSetTest().update("select * from my_test");

//        new RowSetFactoryTest().update("select * from my_test");


//        CachedRowSetTest.test();
//        new Test().test();

        /*CachedRowSetPage page = new CachedRowSetPage();
        CachedRowSet set = page.query("select * from my_test",3,2);
        while (set.next()) {
            System.out.println(set.getString(1)+"\t"+set.getString(2)+"\t"+set.getString(3));
        }*/

        /*TransanctionTest transanctionTest = new TransanctionTest();
        String[] sqls = new String[]{
            "insert into my_test values(null,'aaa',1)",
            "insert into my_test values(null,'aaa',1)",
            "insert into my_test values(null,'aaa',1)",
            "insert into my_test values(null,'aaa',1)"
        };
        transanctionTest.insertInTransanction(sqls);*/

//        DatabaseDataTest.info();

        new QueryExecutor().init();
 }



}
