/*
 * Created by JFormDesigner on Tue May 04 23:45:11 CST 2021
 */

package org.example.ui;

import org.example.ui.login.LoginOrder;
import org.example.ui.login.UserLoginForm;
import org.example.ui.managefoods.ShowFoods;
import org.example.ui.order.OrderJorm;
import org.example.ui.pay.CheckOutForm;
import org.example.ui.queues.QueuingSystem;
import org.example.ui.xmb.Profit;

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

/**
 * @author 1
 */
public class ShowDemo extends JFrame {
    public ShowDemo() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        OrderJorm orderJorm=new OrderJorm();
        orderJorm.OrderJForm();
        orderJorm.setVisible(true);

    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        ShowFoods showFoods=new ShowFoods();
        showFoods.ShowFoods();
        showFoods.setVisible(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        CheckOutForm checkOutForm=new CheckOutForm();
        checkOutForm.setVisible(true);
    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Profit profit=new Profit();
        profit.queryData();
        profit.setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        QueuingSystem queuingSystem=new QueuingSystem();
        queuingSystem.QueuingSystem();
        queuingSystem.setVisible(true);
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
        LoginOrder loginOrder=new LoginOrder();
        loginOrder.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6b22\u8fce\u4f7f\u7528\u6842\u7535\u70b9\u9910\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(115, 10, 250, label1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u70b9\u9910");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(15, 60, 155, 75);

        //---- button2 ----
        button2.setText("\u7ba1\u7406\u83dc\u54c1");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(175, 60, 155, 75);

        //---- button3 ----
        button3.setText("\u7ed3\u8d26");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 5f));
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(335, 60, 155, 75);

        //---- button4 ----
        button4.setText("\u6392\u961f");
        button4.setFont(button4.getFont().deriveFont(button4.getFont().getSize() + 5f));
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(175, 155, 155, 75);

        //---- button5 ----
        button5.setText("\u5229\u6da6\u7edf\u8ba1");
        button5.setFont(button5.getFont().deriveFont(button5.getFont().getSize() + 5f));
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(15, 155, 155, 75);

        //---- button6 ----
        button6.setText("\u9000\u51fa\u767b\u5f55");
        button6.setFont(button6.getFont().deriveFont(button6.getFont().getSize() + 5f));
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6ActionPerformed(e);
            }
        });
        contentPane.add(button6);
        button6.setBounds(335, 155, 155, 75);

        contentPane.setPreferredSize(new Dimension(505, 360));
        pack();
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
