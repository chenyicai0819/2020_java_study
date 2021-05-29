/*
 * Created by JFormDesigner on Tue May 18 17:51:27 CST 2021
 */

package service;

import dao.LinkOracle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.SQLException;
import javax.swing.*;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class UpdateBooks extends JFrame {
    public UpdateBooks(String bid,String bname,String bauthor,String bhome,String mname) {
        initComponents(bid,bname,bauthor,bhome,mname);
    }

    private void initComponents(String bid,String bname,String bauthor,String bhome,String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+bname+"");
        label3 = new JLabel();
        textField2 = new JTextField(""+bauthor+"");
        label4 = new JLabel();
        button1 = new JButton();
        comboBox1 = new JComboBox();
        textField3 = new JTextField(""+bid+"");
        textField3.setEditable(false);
        label5 = new JLabel();
        final String[] Upbhome = {bhome};
        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                ShowDemo showDemo=new ShowDemo(mname);
                showDemo.setVisible(true);
            }

            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });

        //---- label1 ----
        label1.setText("\u4fee\u6539\u4e66\u7c4d");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(80, 10, 90, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u4e66\u7c4d\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(35, 105, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(125, 105, 110, 30);

        //---- label3 ----
        label3.setText("\u4e66\u7c4d\u4f5c\u8005\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(35, 145, 80, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 145, 110, 30);

        //---- label4 ----
        label4.setText("\u6240 \u5728 \u5730\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(35, 185, 80, 30);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(70, 225, 125, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkOracle linkOracle=new LinkOracle();
                        String set1=bid;
                        String set2=textField1.getText();
                        String set3=textField2.getText();
                        Upbhome[0] = (String) comboBox1.getSelectedItem();
                        String sqlUp="UPDATE books SET bname='"+set2+"',bauthor='"+set3+"',bhome='"+Upbhome[0]+"' WHERE bid='"+set1+"'";
                        System.out.println(sqlUp);
                        try {
                            linkOracle.LinkOracle();
                            int a=stmt.executeUpdate(sqlUp);
                            if(a==1){
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, set1+"修改成功", "修改成功", JOptionPane.WARNING_MESSAGE);
                            }else{
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "再检查一下吧", "修改失败", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }finally {
                            try {
                                LinkOracle.conn.close();
                                stmt.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );
        contentPane.add(comboBox1);
        comboBox1.setBounds(125, 185, 110, 30);
        comboBox1.addItem(""+bhome+"");
        comboBox1.addItem("1楼A库");
        comboBox1.addItem("1楼B库");
        comboBox1.addItem("1楼C库");
        comboBox1.addItem("2楼A库");
        comboBox1.addItem("2楼B库");
        comboBox1.addItem("2楼C库");
        comboBox1.addItem("3楼A库");
        comboBox1.addItem("3楼B库");
        comboBox1.addItem("3楼C库");
        contentPane.add(textField3);
        textField3.setBounds(125, 65, 110, 30);

        //---- label5 ----
        label5.setText("\u4e66\u7c4d ID\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5);
        label5.setBounds(35, 65, 80, 30);

        contentPane.setPreferredSize(new Dimension(275, 300));
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
    private JLabel label4;
    private JButton button1;
    private JComboBox comboBox1;
    private JTextField textField3;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
