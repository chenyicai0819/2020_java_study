/*
 * Created by JFormDesigner on Mon Apr 26 15:43:58 CST 2021
 */

package org.example.ui.managefoods;


import org.example.dao.LinkOracle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import static org.example.dao.LinkOracle.*;
/**
 * @author 1
 */
public class SystemFood extends JFrame {
    public void SystemFood() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String fid=textField1.getText();
        String fname=textField4.getText();
        String fmoney=textField3.getText();
        String fclass=textField5.getText();
        String sql = "INSERT INTO foods VALUES(?,?,?,?)";
        LinkOracle linkOracle = new LinkOracle();
        String Ex="";
        try {
            linkOracle.LinkOracle();
            pstt=conn.prepareStatement(sql);
            pstt.setObject(1,fid);
            pstt.setObject(2,fname);
            pstt.setObject(3,fmoney);
            pstt.setObject(4,fclass);
            int a=pstt.executeUpdate();
            if(a>0){
                Component jPanel1 = null;
                JOptionPane.showMessageDialog(jPanel1, "添加了一道新菜品", "添加成功",JOptionPane.WARNING_MESSAGE);
            }
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLIntegrityConstraintViolationException ee){
            Ex="违反数据库唯一性";
            System.out.println("违反数据库唯一性");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                pstt.close();
                conn.close();
                if(Ex=="违反数据库唯一性"){
                    Component jPanel2 = null;
                    JOptionPane.showMessageDialog(jPanel2, "这个菜品已经有了或者没有这个菜品类别", "添加失败",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String fid=textField2.getText();
        String fmoney=textField6.getText();
        String sql = "UPDATE foods SET fmoney="+fmoney+" WHERE fid='"+fid+"'";
        LinkOracle linkOracle = new LinkOracle();
        try {
            linkOracle.LinkOracle();
            stmt=conn.createStatement();
            int a=stmt.executeUpdate(sql);
            if(a>0){
                System.out.println("修改成功");
                Component jPanel1 = null;
                JOptionPane.showMessageDialog(jPanel1, "修改价格成功，新的价格为"+fmoney, "修改成功",JOptionPane.WARNING_MESSAGE);
            }else{
                Component jPanel1 = null;
                JOptionPane.showMessageDialog(jPanel1, "没有找到"+fid+"这道菜喔", "修改失败",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String fid=textField7.getText();
        String sql = "DELETE FROM foods WHERE fid='"+fid+"'";
        LinkOracle linkOracle = new LinkOracle();
        try {
            linkOracle.LinkOracle();
            stmt=conn.createStatement();
            int a=stmt.executeUpdate(sql);
            if(a>0){
                System.out.println("删除成功");
                Component jPanel1 = null;
                JOptionPane.showMessageDialog(jPanel1, "已经帮你删除这道菜咯", "删除成功",JOptionPane.WARNING_MESSAGE);
            }else{
                Component jPanel1 = null;
                JOptionPane.showMessageDialog(jPanel1, "没有找到"+fid+"这道菜喔", "删除失败",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label4 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        label5 = new JLabel();
        textField3 = new JTextField();
        label6 = new JLabel();
        textField4 = new JTextField();
        label7 = new JLabel();
        textField5 = new JTextField();
        label8 = new JLabel();
        button1 = new JButton();
        label9 = new JLabel();
        textField2 = new JTextField();
        label10 = new JLabel();
        textField6 = new JTextField();
        button2 = new JButton();
        label11 = new JLabel();
        label12 = new JLabel();
        label13 = new JLabel();
        textField7 = new JTextField();
        button3 = new JButton();

        //======== this ========
        setResizable(false);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label4 ----
        label4.setText("George\u00a9");
        contentPane.add(label4);
        label4.setBounds(410, 305, 55, 17);

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u83dc\u54c1");
        contentPane.add(label1);
        label1.setBounds(10, 35, 100, 20);

        //---- label2 ----
        label2.setText("\u83dc\u54c1\u7c7b\u522b\u4e3a\uff1a\u4e3b\u98df \u6c64\u7c7b \u8364\u83dc \u9152\u6c34 \u7d20\u83dc \u9762\u98df");
        contentPane.add(label2);
        label2.setBounds(180, 35, 275, 20);

        //---- label3 ----
        label3.setText("\u83dc\u54c1\u53f7");
        contentPane.add(label3);
        label3.setBounds(10, 60, 55, 25);
        contentPane.add(textField1);
        textField1.setBounds(65, 60, 80, 25);

        //---- label5 ----
        label5.setText("\u83dc\u54c1\u7c7b\u522b");
        contentPane.add(label5);
        label5.setBounds(165, 60, 55, 25);
        contentPane.add(textField3);
        textField3.setBounds(220, 90, 80, 25);

        //---- label6 ----
        label6.setText("\u83dc\u54c1\u4ef7\u683c");
        contentPane.add(label6);
        label6.setBounds(165, 90, 55, 25);
        contentPane.add(textField4);
        textField4.setBounds(65, 90, 80, 25);

        //---- label7 ----
        label7.setText("\u83dc\u54c1\u540d");
        contentPane.add(label7);
        label7.setBounds(10, 90, 55, 25);
        contentPane.add(textField5);
        textField5.setBounds(220, 60, 80, 25);

        //---- label8 ----
        label8.setText("\u4fee\u6539\u83dc\u54c1\u4ef7\u683c");
        contentPane.add(label8);
        label8.setBounds(10, 135, 100, 20);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(330, 85, 78, 30);

        //---- label9 ----
        label9.setText("\u8f93\u5165\u8981\u66f4\u6539\u7684\u83dc\u54c1\u53f7");
        contentPane.add(label9);
        label9.setBounds(10, 160, 140, 25);
        contentPane.add(textField2);
        textField2.setBounds(145, 160, 80, 25);

        //---- label10 ----
        label10.setText("\u8f93\u5165\u8981\u66f4\u6539\u7684\u83dc\u54c1\u4ef7\u683c");
        contentPane.add(label10);
        label10.setBounds(10, 190, 140, 25);
        contentPane.add(textField6);
        textField6.setBounds(145, 190, 80, 25);

        //---- button2 ----
        button2.setText("\u4fee\u6539");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(330, 185, 78, 30);

        //---- label11 ----
        label11.setText("\u6842\u7535\u9910\u9986\u83dc\u54c1\u7ba1\u7406\u7cfb\u7edf");
        contentPane.add(label11);
        label11.setBounds(145, 5, 145, 20);

        //---- label12 ----
        label12.setText("\u5220\u9664\u83dc\u54c1");
        contentPane.add(label12);
        label12.setBounds(10, 245, 100, 20);

        //---- label13 ----
        label13.setText("\u8f93\u5165\u8981\u5220\u9664\u7684\u83dc\u54c1\u53f7");
        contentPane.add(label13);
        label13.setBounds(10, 270, 140, 25);
        contentPane.add(textField7);
        textField7.setBounds(145, 270, 80, 25);

        //---- button3 ----
        button3.setText("\u5220\u9664");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(330, 265, 78, 30);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label4;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JLabel label5;
    private JTextField textField3;
    private JLabel label6;
    private JTextField textField4;
    private JLabel label7;
    private JTextField textField5;
    private JLabel label8;
    private JButton button1;
    private JLabel label9;
    private JTextField textField2;
    private JLabel label10;
    private JTextField textField6;
    private JButton button2;
    private JLabel label11;
    private JLabel label12;
    private JLabel label13;
    private JTextField textField7;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
