/*
 * Created by JFormDesigner on Tue May 18 18:56:45 CST 2021
 */

package service;

import dao.LinkOracle;
import message.MD5;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import static dao.LinkOracle.*;

/**
 * @author 1
 */
public class ManageDate extends JFrame {
    public ManageDate(int mid,String mname) {
        initComponents(mid,mname);
    }

    private void initComponents(int mid,String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+mid+"");
        label3 = new JLabel();
        textField2 = new JTextField(""+mname+"");
        button1 = new JButton();
        label4 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label5 = new JLabel();
        textField1.setEditable(false);
        textField2.setEditable(false);

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
        label1.setText("\u6211\u7684\u8d44\u6599");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(80, 10, 110, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7528\u6237ID\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(35, 70, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(125, 70, 110, 30);

        //---- label3 ----
        label3.setText("\u7528\u6237\u540d\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(35, 110, 80, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 110, 110, 30);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u4fee\u6539");
        contentPane.add(button1);
        button1.setBounds(70, 220, 125, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String newpwd1= MD5.encoderByMd5(textField4.getText());
                            String newpwd2= MD5.encoderByMd5(textField3.getText());
                            if(!newpwd1.equals(newpwd2)){
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "两次输入的密码不一样", "错误", JOptionPane.ERROR_MESSAGE);
                            }else{
                                LinkOracle linkOracle=new LinkOracle();
                                linkOracle.LinkOracle();
                                String sqlUp="UPDATE manages SET mpwd='"+newpwd2+"' WHERE mid="+mid;
                                System.out.println(sqlUp);
                                int a=stmt.executeUpdate(sqlUp);
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "修改成功", "修改成功", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } finally {
                            try {
                                conn.close();
                                stmt.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- label4 ----
        label4.setText("\u518d\u6b21\u8f93\u5165\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(35, 185, 80, 30);
        contentPane.add(textField3);
        textField3.setBounds(125, 185, 110, 30);
        contentPane.add(textField4);
        textField4.setBounds(125, 155, 110, 30);

        //---- label5 ----
        label5.setText("\u65b0\u5bc6\u7801\uff1a");
        label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 4f));
        contentPane.add(label5);
        label5.setBounds(35, 155, 80, 30);

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
    private JButton button1;
    private JLabel label4;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
