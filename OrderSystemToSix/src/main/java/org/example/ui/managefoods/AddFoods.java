/*
 * Created by JFormDesigner on Thu Apr 29 00:28:35 CST 2021
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
public class AddFoods extends JFrame {
    public void AddFoods() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String fid=textField1.getText();
        String fname=textField2.getText();
        String fmoney=textField3.getText();
        String fclass= (String) comboBox1.getSelectedItem();
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
            System.out.println(sql);
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        comboBox1 = new JComboBox();

        //======== this ========
        setResizable(false);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u83dc\u54c1");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(105, 10, 85, label1.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u83dc\u54c1\u540d\u79f0\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(25, 90, 80, 30);

        //---- label4 ----
        label4.setText("\u83dc\u54c1\u4ef7\u683c\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(25, 130, 80, 30);

        //---- label5 ----
        label5.setText("\u83dc\u54c1\u5206\u7c7b\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5);
        label5.setBounds(25, 175, 80, 30);

        //---- label6 ----
        label6.setText("\u83dc\u54c1\u53f7\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        contentPane.add(label6);
        label6.setBounds(25, 50, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(120, 55, 140, 30);
        contentPane.add(textField2);
        textField2.setBounds(120, 95, 140, 30);
        contentPane.add(textField3);
        textField3.setBounds(120, 135, 140, 30);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(70, 225, 135, 35);
        contentPane.add(comboBox1);
        comboBox1.addItem("素菜");
        comboBox1.addItem("荤菜");
        comboBox1.addItem("汤类");
        comboBox1.addItem("酒水");
        comboBox1.addItem("面食");
        comboBox1.addItem("主食");
        comboBox1.setBounds(120, 180, 140, 30);

        contentPane.setPreferredSize(new Dimension(315, 310));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
