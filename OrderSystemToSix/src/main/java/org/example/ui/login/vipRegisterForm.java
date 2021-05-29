package org.example.ui.login;

import org.example.ui.vips.Vip;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 07 21:43:55 CST 2021
 */



/**
 * @author 1
 */
public class vipRegisterForm extends JFrame {
    public vipRegisterForm() {
        this.setPreferredSize(new Dimension(400, 400));
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();


        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f1a\u5458\u6ce8\u518c\u9875\u9762");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(135, 40), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u8d26\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(75, 90), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(75, 130), label3.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(120, 85, 175, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(120, 125, 175, textField2.getPreferredSize().height);

        //---- 会员注册按钮 ----
        button1.setText("\u6ce8\u518c");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(75, 230), button1.getPreferredSize()));
        /*
        连接会员注册监听事件
         */
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String name=textField1.getText();
                        String password=textField2.getText();
                        String phonenumber=textField3.getText();
                        if(Vip.registerVip(name, password, phonenumber)){
                            JOptionPane.showMessageDialog(null, "注册成功", "会员注册", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }else{
                            JOptionPane.showMessageDialog(null, "该用户名已被注册", "错误", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                }
        );

        //---- button2 ----
        button2.setText("\u9000\u51fa");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(240, 230), button2.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u7535\u8bdd\u53f7\u7801\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(55, 170), label4.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(120, 165, 170, textField3.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(460, 345));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
