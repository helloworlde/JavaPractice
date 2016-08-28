package executesql;

import conn.ConnMySQL;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.*;

/**
 * Created by alpha on 16-8-16.
 * 通过Statement和PreparedStatement进行验证
 * Statement有注入风险
 */
public class LoginFrame {
    private JFrame jf = new JFrame("登录");
    private JTextField userFiled = new JTextField(50);
    private JTextField passFiled = new JTextField(50);
    private JButton loginButton = new JButton("登录");

    public void init() {
        loginButton.addActionListener(e -> {
            if (validate(userFiled.getText(), passFiled.getText())) {
                JOptionPane.showMessageDialog(jf, "登录成功");
            } else {
                JOptionPane.showMessageDialog(jf, "登录失败");
            }
        });
        jf.add(userFiled, BorderLayout.NORTH);
        jf.add(passFiled);
        jf.add(loginButton, BorderLayout.SOUTH);
        jf.pack();
        jf.setVisible(true);
    }

    //Statement 使用 ' or true or '可以进行注入绕过验证
    /*private boolean validate(String username, String password) {
        String sql = "Select * from my_test where name = '" + username + "' and pass = '" + password +"'";
        System.out.println(sql);
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }*/

    //PreparedStatement 可以避免注入
    private boolean validate(String username, String password) {
        try (Connection conn = ConnMySQL.getConnection("mysql.ini");
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM my_test WHERE name = ? and pass = ?")) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
