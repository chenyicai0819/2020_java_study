/*
 * Created by JFormDesigner on Fri May 14 22:53:46 CST 2021
 */

package org.example.ui.login;

import oracle.jdbc.driver.OracleDriver;
import org.example.dao.LinkOracle;
import org.example.message.MD5;
import org.example.ui.ShowDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author 1
 */
public class UserUpdateForm extends JFrame {
    public UserUpdateForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label5 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4fee\u6539\u7528\u6237\u5bc6\u7801");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(105, 15, 165, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(70, 50, 65, 30);
        contentPane.add(textField1);
        textField1.setBounds(145, 50, 120, 30);
        contentPane.add(textField2);
        textField2.setBounds(145, 85, 120, 30);

        //---- label3 ----
        label3.setText("\u5bc6    \u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(70, 85, 65, 30);

        //---- label4 ----
        label4.setText("\u65b0\u5bc6\u7801\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
        contentPane.add(label4);
        label4.setBounds(70, 120, 65, 30);
        contentPane.add(textField3);
        textField3.setBounds(145, 120, 120, 30);
        contentPane.add(textField4);
        textField4.setBounds(145, 155, 120, 30);

        //---- label5 ----
        label5.setText("\u518d\u6b21\u8f93\u5165\u65b0\u5bc6\u7801\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
        contentPane.add(label5);
        label5.setBounds(10, 155, 125, 30);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(70, 195, 195, 45);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username1=textField1.getText();
                        String oldpwd=textField2.getText();
                        String newpwd1=textField3.getText();
                        String newpwd2=textField4.getText();
                        String sql1="SELECT upassword FROM users WHERE uname='"+username1+"'";
                        System.out.println(sql1);
                        ResultSet rs=null;
                        try {
                            LinkOracle linkOracle=new LinkOracle();
                            linkOracle.LinkOracle();
                            rs=LinkOracle.stmt.executeQuery(sql1);
                            rs.next();
                            String userpwdOut=rs.getString(1);
                            String useroldpwd=MD5.encoderByMd5(oldpwd);
                            if(useroldpwd.equals(userpwdOut)){
                                System.out.println("原来密码正确");
                                if(newpwd1.equals(newpwd2)){
                                    String newpwd3=MD5.encoderByMd5(newpwd2);
                                    String sql2="UPDATE users SET upassword='"+newpwd3+"' WHERE uname='"+username1+"'";
                                    LinkOracle.stmt.executeUpdate(sql2);
                                    System.out.println(sql2);
                                    Component jPanel = null;
                                    JOptionPane.showMessageDialog(jPanel, "成功修改密码", "修改成功", JOptionPane.WARNING_MESSAGE);
                                    UserLoginForm userLoginForm=new UserLoginForm();
                                    setVisible(false);
                                    dispose();
                                    userLoginForm.setVisible(true);
                                }else{
                                    Component jPanel = null;
                                    JOptionPane.showMessageDialog(jPanel, "两次输入的密码不一致", "密码不一致", JOptionPane.ERROR_MESSAGE);
                                }
                            }else{
                                System.out.println("密码错误");
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "输入旧密码错误", "密码错误", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        } finally {
                            try {
                                LinkOracle.stmt.close();
                                rs.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(345, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label5;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
