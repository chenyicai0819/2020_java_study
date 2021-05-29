/*
 * Created by JFormDesigner on Thu Apr 29 00:42:03 CST 2021
 */

package org.example.ui.managefoods;

import org.example.dao.LinkOracle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.example.dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ReFoods extends JFrame {
    String Refood1="";
    String Refood2="";
    LinkOracle linkOracle=new LinkOracle();
    public void ReFoods(String foodid) {
        initComponents(foodid);
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Refood1=textField4.getText();
        Refood2=textField1.getText();
        String sql1="UPDATE foods SET fmoney='"+Refood2+"' WHERE fid='"+Refood1+"'";
        System.out.println(sql1);
        try {
            linkOracle.LinkOracle();
            int a=stmt.executeUpdate(sql1);
            if(a==1){
                Component jPanel = null;
                JOptionPane.showMessageDialog(jPanel, textField3.getText()+"的价格修改为"+Refood2, "修改成功", JOptionPane.WARNING_MESSAGE);
            }else{
                Component jPanel = null;
                JOptionPane.showMessageDialog(jPanel, "再检查一下吧", "修改失败", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                LinkOracle.conn.close();
                stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        Refood1=textField4.getText();
        String sql2="SELECT * FROM foods WHERE fid='"+Refood1+"'";
        System.out.println(sql2);
        ResultSet rs = null;
        try {
            linkOracle.LinkOracle();
            rs = stmt.executeQuery(sql2);
            rs.next();
            String name1=rs.getString(2);
            int money1=rs.getInt(3);
            textField3.setText(name1);
            textField2.setText(String.valueOf(money1));
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException throwables) {
            Component jPanel = null;
            JOptionPane.showMessageDialog(jPanel, "没有找到这个菜品", "提示", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                rs.close();
                stmt.close();
                LinkOracle.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

    private void initComponents(String foodid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label9 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        textField2 = new JTextField();
        label10 = new JLabel();
        textField3 = new JTextField();
        label11 = new JLabel();
        textField4 = new JTextField(foodid);
        label12 = new JLabel();
        button2 = new JButton();

        //======== this ========
        setVisible(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4fee\u6539\u4ef7\u683c");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(100, 10, 85, 24);

        //---- label9 ----
        label9.setText("\u66f4\u6539\u4ef7\u683c\uff1a");
        label9.setFont(label9.getFont().deriveFont(label9.getFont().getSize() + 4f));
        contentPane.add(label9);
        label9.setBounds(35, 200, 95, 30);
        contentPane.add(textField1);
        textField1.setBounds(125, 200, 138, 30);

        //---- button1 ----
        button1.setText("\u4fee\u6539");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(80, 265, 135, 35);

        //---- textField2 ----
        textField2.setEditable(false);
        contentPane.add(textField2);
        textField2.setBounds(125, 150, 138, 30);

        //---- label10 ----
        label10.setText("\u83dc\u54c1\u4ef7\u683c\uff1a");
        label10.setFont(label10.getFont().deriveFont(label10.getFont().getSize() + 4f));
        contentPane.add(label10);
        label10.setBounds(35, 150, 95, 30);

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3);
        textField3.setBounds(125, 105, 138, 30);

        //---- label11 ----
        label11.setText("\u83dc\u54c1\u540d\u79f0\uff1a");
        label11.setFont(label11.getFont().deriveFont(label11.getFont().getSize() + 4f));
        contentPane.add(label11);
        label11.setBounds(35, 105, 95, 30);
        contentPane.add(textField4);
        textField4.setBounds(125, 55, 95, 30);

        //---- label12 ----
        label12.setText("\u83dc\u54c1\u53f7\uff1a");
        label12.setFont(label12.getFont().deriveFont(label12.getFont().getSize() + 4f));
        contentPane.add(label12);
        label12.setBounds(35, 55, 95, 30);

        //---- button2 ----
        button2.setText("go");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(225, 55, 40, 30);

        contentPane.setPreferredSize(new Dimension(305, 340));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label9;
    private JTextField textField1;
    private JButton button1;
    private JTextField textField2;
    private JLabel label10;
    private JTextField textField3;
    private JLabel label11;
    private JTextField textField4;
    private JLabel label12;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
