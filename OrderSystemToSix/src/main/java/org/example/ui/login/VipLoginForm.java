/*
 * Created by JFormDesigner on Fri May 14 22:37:06 CST 2021
 */

package org.example.ui.login;

import org.example.message.MD5;
import org.example.ui.vips.Vip;
import org.example.ui.vips.VipForm;

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
public class VipLoginForm extends JFrame {
    public VipLoginForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField("kk");
        label3 = new JLabel();
        textField2 = new JPasswordField("kk1234");
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f1a\u5458\u767b\u5f55\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(110, 5, 160, 35);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(65, 65, 65, 30);
        contentPane.add(textField1);
        textField1.setBounds(140, 65, 120, 30);

        //---- label3 ----
        label3.setText("\u5bc6    \u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(65, 100, 65, 30);
        contentPane.add(textField2);
        textField2.setBounds(140, 100, 120, 30);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(65, 145, 195, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();
                        String password=textField2.getText();
                        try {
                            ResultSet rs = Vip.getResultSet(username, MD5.encoderByMd5(password));
                            if(rs.next()){
                                System.out.println("登录成功");
                                Vip vip = new Vip(rs);
                                new VipForm(vip);
                                dispose();
                            }else{
                                System.out.println("登录失败");
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "用户名或密码错误，请重新输入", "登陆失败", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        }
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        contentPane.add(button2);
        button2.setBounds(195, 180, 65, 25);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        vipRegisterForm vf=new vipRegisterForm();
                        vf.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(350, 265));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
