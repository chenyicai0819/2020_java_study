/*
 * Created by JFormDesigner on Tue May 18 16:32:41 CST 2021
 */

package service;

import dao.LinkOracle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static dao.LinkOracle.*;

/**
 * @author 1
 */
public class AddBooks extends JFrame {
    public AddBooks(String mname) {
        initComponents(mname);
    }

    private void initComponents(String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
        label4 = new JLabel();
        button1 = new JButton();
        comboBox1 = new JComboBox();

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
        label1.setText("\u6dfb\u52a0\u4e66\u7c4d");
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

        //---- label4 ----
        label4.setText("\u6240 \u5728 \u5730\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 4f));
        contentPane.add(label4);
        label4.setBounds(35, 150, 80, 30);

        //---- button1 ----
        button1.setText("\u786e\u8ba4\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(70, 195, 125, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkOracle linkOracle=new LinkOracle();
                        String NumSQL="SELECT max(bid) FROM books";
                        String AddSQL="INSERT INTO books VALUES(?,?,?,?,?)";
                        System.out.println(NumSQL);
                        System.out.println(AddSQL);
                        ResultSet rs=null;
                        String Ex="";
                        try {
                            linkOracle.LinkOracle();
                            rs = stmt.executeQuery(NumSQL);
                            rs.next();
                            int bid=1+rs.getInt(1);
                            String sname="入藏";
                            String bname=textField1.getText();
                            String baustor=textField2.getText();
                            String bhome= (String) comboBox1.getSelectedItem();
                            pstt=conn.prepareStatement(AddSQL);
                            pstt.setObject(1,bid);
                            pstt.setObject(2,sname);
                            pstt.setObject(3,bname);
                            pstt.setObject(4,baustor);
                            pstt.setObject(5,bhome);
                            int a=pstt.executeUpdate();
                            if(a>0){
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "添加了一本新书", "添加成功",JOptionPane.WARNING_MESSAGE);
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
                                rs.close();
                                pstt.close();
                                conn.close();
                                if(Ex=="违反数据库唯一性"){
                                    Component jPanel2 = null;
                                    JOptionPane.showMessageDialog(jPanel2, "违反数据库唯一性", "添加失败",JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }

                    }
                }
        );

        contentPane.add(comboBox1);
        comboBox1.setBounds(125, 150, 110, 30);
        comboBox1.addItem("1楼A库");
        comboBox1.addItem("1楼B库");
        comboBox1.addItem("1楼C库");
        comboBox1.addItem("2楼A库");
        comboBox1.addItem("2楼B库");
        comboBox1.addItem("2楼C库");
        comboBox1.addItem("3楼A库");
        comboBox1.addItem("3楼B库");
        comboBox1.addItem("3楼C库");

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
