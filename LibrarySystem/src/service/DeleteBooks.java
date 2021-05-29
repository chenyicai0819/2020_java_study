/*
 * Created by JFormDesigner on Tue May 18 18:34:12 CST 2021
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

import static dao.LinkOracle.conn;
import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class DeleteBooks extends JFrame {
    public DeleteBooks(String bid,String bname,String bauthor,String sname,String bhome,String mname) {
        initComponents(bid,bname,bauthor,sname,bhome,mname);
    }

    private void initComponents(String bid,String bname,String bauthor,String sname,String bhome,String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+bname+"");
        label3 = new JLabel();
        textField2 = new JTextField(""+bauthor+"");
        label4 = new JLabel();
        button1 = new JButton();
        textField3 = new JTextField(""+bid+"");
        label5 = new JLabel();
        textField4 = new JTextField(""+bhome+"");
        label6 = new JLabel();
        textField5 = new JTextField(""+sname+"");
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);
        textField4.setEditable(false);
        textField5.setEditable(false);

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
        label1.setText("\u5220\u9664\u4e66\u7c4d");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(80, 10, 90, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u4e66\u7c4d\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(35, 75, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(125, 75, 110, 30);

        //---- label3 ----
        label3.setText("\u4e66\u7c4d\u4f5c\u8005\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(35, 110, 80, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 110, 110, 30);

        //---- label4 ----
        label4.setText("\u6240 \u5728 \u5730\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(35, 185, 80, 30);

        //---- button1 ----
        button1.setText("确认删除");
        contentPane.add(button1);
        button1.setBounds(70, 225, 125, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkOracle linkOracle=new LinkOracle();
                        String DelSQL="DELETE FROM books WHERE bid='" + bid + "'";
                        System.out.println(DelSQL);
                        try {
                            linkOracle.LinkOracle();
                            int deleteOK = stmt.executeUpdate(DelSQL);
                            if (deleteOK == 1) {
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "成功删除了" + bname , "删除成功", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            try {
                                stmt.close();
                                conn.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );
        contentPane.add(textField3);
        textField3.setBounds(125, 40, 110, 30);

        //---- label5 ----
        label5.setText("\u4e66\u7c4d ID\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5);
        label5.setBounds(35, 40, 80, 30);
        contentPane.add(textField4);
        textField4.setBounds(125, 185, 110, 30);

        //---- label6 ----
        label6.setText("\u72b6    \u6001\uff1a");
        label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 4f));
        contentPane.add(label6);
        label6.setBounds(35, 145, 80, 30);
        contentPane.add(textField5);
        textField5.setBounds(125, 145, 110, 30);

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
    private JTextField textField3;
    private JLabel label5;
    private JTextField textField4;
    private JLabel label6;
    private JTextField textField5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
