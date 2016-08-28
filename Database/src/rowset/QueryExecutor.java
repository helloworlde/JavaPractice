package rowset;

import conn.ConnMySQL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.util.Vector;

/**
 * Created by alpha on 16-8-18.
 */
public class QueryExecutor {
    JFrame jf = new JFrame("查询执行器");
    private JScrollPane scrollPane;
    private JButton execBn = new JButton("查询");
    //用于输入查询语句的文本框
    private JTextField sqlField = new JTextField(45);
    private static Connection connection;
    private static Statement statement;

    static {
        try {
            connection = ConnMySQL.getConnection("mysql.ini");
            statement = connection.createStatement();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //初始化界面的方法
    public void init() {
        JPanel top = new JPanel();
        top.add(new JLabel("输入查询语句"));
        top.add(sqlField);
        top.add(execBn);
        //为执行按钮，单行文本框添加事件监听器
        execBn.addActionListener(new ExceListener());
        sqlField.addActionListener(new ExceListener());
        jf.add(top, BorderLayout.NORTH);
        jf.setSize(680, 480);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }


    class ExceListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (scrollPane != null) {
                jf.remove(scrollPane);
            }
            try (ResultSet rs = statement.executeQuery(sqlField.getText())){
                ResultSetMetaData resultSetMetaData = rs.getMetaData();
                Vector<String> columnNames = new Vector<>();
                Vector<Vector<String>> data = new Vector<>();

                for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                    columnNames.add(resultSetMetaData.getColumnName(i + 1));
                }

                while (rs.next()) {
                    Vector<String> v = new Vector<>();
                    for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
                        v.add(rs.getString(i + 1));

                    }
                    data.add(v);

                    JTable table = new JTable(data, columnNames);
                    scrollPane = new JScrollPane(table);
                    jf.add(scrollPane);
                    jf.validate();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}
