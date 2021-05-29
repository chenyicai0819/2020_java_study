/*
 * Created by JFormDesigner on Wed May 19 12:05:24 CST 2021
 */

package reader;

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
public class ReaderRenewBooks extends JFrame {
    public ReaderRenewBooks(String bid,String bname,String bauthor,String date,int rid) {
        initComponents(bid,bname,bauthor,date,rid);
    }

    private void initComponents(String bid,String bname,String bauthor,String date,int rid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+bname+"");
        label3 = new JLabel();
        textField2 = new JTextField(""+bauthor+"");
        button1 = new JButton();
        label4 = new JLabel();
        textField3 = new JTextField(""+date+"");
        textField1.setEditable(false);
        textField2.setEditable(false);
        textField3.setEditable(false);

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderShowDemo readerShowDemo=new ReaderShowDemo(rid);
                readerShowDemo.setVisible(true);
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
        label1.setText("\u7eed\u501f\u4e66\u7c4d");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(80, 10, 90, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u4e66\u7c4d\u540d\u79f0\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(35, 70, 80, 30);
        contentPane.add(textField1);
        textField1.setBounds(125, 70, 110, 30);

        //---- label3 ----
        label3.setText("\u4e66\u7c4d\u4f5c\u8005\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(35, 110, 80, 30);
        contentPane.add(textField2);
        textField2.setBounds(125, 110, 110, 30);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u7eed\u501f");
        contentPane.add(button1);
        button1.setBounds(70, 195, 125, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkOracle linkOracle=new LinkOracle();
                        try {
                            linkOracle.LinkOracle();
                            String sqlUpre="UPDATE renew SET rno=1 WHERE bid='"+bid+"'";
                            String sqlDate="UPDATE readerbook SET rbtime='"+date+"' WHERE bid='"+bid+"'";
                            int a=stmt.executeUpdate(sqlDate);
                            int b=stmt.executeUpdate(sqlUpre);
                            if(a==1&&b==1){
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "请在"+date+"之前归还", "续借成功", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "续借失败", "续借失败", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );

        //---- label4 ----
        label4.setText("\u5f52\u8fd8\u65f6\u95f4\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(35, 155, 80, 30);
        contentPane.add(textField3);
        textField3.setBounds(125, 155, 110, 30);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
