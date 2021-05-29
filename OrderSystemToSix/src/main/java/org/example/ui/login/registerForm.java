package org.example.ui.login;


import org.example.message.MD5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 28 16:59:39 CST 2021
 */



/**
 * @author 1
 */
public class registerForm extends JFrame {
    public registerForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u9875\u9762");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u65b0\u7528\u6237\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 85), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(55, 125), label3.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(125, 75, 115, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(125, 120, 115, textField2.getPreferredSize().height);

        //---- 注册按钮 ----
        button1.setText("\u6ce8\u518c");
        contentPane.add(button1);
        button1.setBounds(60, 190, button1.getPreferredSize().width, 30);
        /*
        连接注册监听事件，新用户输入新的账号密码后，按下注册按钮，将新用户的信息存入数据库中
         */
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();
                        String password=textField2.getText();
                        String md5password = "";
                        try {
                            md5password=MD5.encoderByMd5(password);
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        }
                        int radom = (int)(Math.random()*100000);
                        Connection conn=null;
                        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt=null;//SQL语句对象
                        String sql="INSERT INTO users VALUES ('"+radom+"','"+username+"','"+md5password+"')" ;
                        System.out.println("即将执行的sql："+sql);
                        ResultSet rs=null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn= DriverManager.getConnection(url,"dcxt","dcxt1234");
                            stmt=conn.createStatement();
                            rs=stmt.executeQuery(sql);
                            if(rs.next()){
                                System.out.println("注册成功");
                                setVisible(false);
                                successForm sf=new successForm();
                                sf.setVisible(true);
                            }

                        } catch (ClassNotFoundException | SQLException ee) {
                            ee.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                rs.close();
                                stmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }

                    }
                }
        );


        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(180, 190), button2.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
