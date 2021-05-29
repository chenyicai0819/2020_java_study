/*
 * Created by JFormDesigner on Tue May 18 10:59:24 CST 2021
 */

package service;

import Login.LoginOrder;
import dao.LinkOracle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static dao.LinkOracle.conn;
import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ShowDemo extends JFrame {
    String sql ="SELECT * FROM books order by bid";
    public ShowDemo(String mname) {
        initComponents(mname);
    }

    private void initComponents(String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        button1 = new JButton();
        comboBox1 = new JComboBox();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();


        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 15, 460, 315);
        contentPane.add(textField1);
        textField1.setBounds(485, 15, 160, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u641c\u7d22");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(565, 50, 80, 30);
        button1.addActionListener(
                new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent e) {
                        String text1=textField1.getText();
                        String com1= (String) comboBox1.getSelectedItem();
                        LinkOracle linkOracle=new LinkOracle();
                        try {
                            linkOracle.LinkOracle();
                            if(com1.equals("全部")){
                                sql="SELECT * FROM books WHERE bname like '%"+text1+"%' OR bauthor like '%"+text1+"%' order by bid";
                                DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table1.setModel(tableModel);
                            }else if(com1.equals("书名")){
                                sql="SELECT * FROM books WHERE bname like '%"+text1+"%' order by bid";
                                DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table1.setModel(tableModel);
                            }else if(com1.equals("作者")){
                                sql="SELECT * FROM books WHERE bauthor like '%"+text1+"%' order by bid";
                                DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table1.setModel(tableModel);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                }
        );
        contentPane.add(comboBox1);
        comboBox1.setBounds(485, 50, 80, comboBox1.getPreferredSize().height);
        comboBox1.addItem("全部");
        comboBox1.addItem("书名");
        comboBox1.addItem("作者");

        //---- button2 ----
        button2.setText("\u6dfb\u52a0\u56fe\u4e66");
        contentPane.add(button2);
        button2.setBounds(495, 90, 147, button2.getPreferredSize().height);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        AddBooks addBooks=new AddBooks(mname);
                        setVisible(false);
                        dispose();
                        addBooks.setVisible(true);
                    }
                }
        );

        //---- button3 ----
        button3.setText("\u4fee\u6539\u56fe\u4e66");
        contentPane.add(button3);
        button3.setBounds(495, 125, 147, button3.getPreferredSize().height);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        String get1 = table1.getValueAt(count, 0).toString();
                        String get2 = table1.getValueAt(count, 1).toString();
                        String get3 = table1.getValueAt(count, 2).toString();
                        String get5 = table1.getValueAt(count, 4).toString();
                        UpdateBooks updateBooks=new UpdateBooks(get1,get2,get3,get5,mname);
                        setVisible(false);
                        dispose();
                        updateBooks.setVisible(true);
                    }
                }
        );

        //---- button4 ----
        button4.setText("\u5220\u9664\u56fe\u4e66");
        contentPane.add(button4);
        button4.setBounds(495, 160, 147, button4.getPreferredSize().height);
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        String get1 = table1.getValueAt(count, 0).toString();
                        String get2 = table1.getValueAt(count, 1).toString();
                        String get3 = table1.getValueAt(count, 2).toString();
                        String get4 = table1.getValueAt(count, 3).toString();
                        String get5 = table1.getValueAt(count, 4).toString();
                        DeleteBooks deleteBooks=new DeleteBooks(get1,get2,get3,get4,get5,mname);
                        setVisible(false);
                        dispose();
                        deleteBooks.setVisible(true);
                    }
                }
        );

        //---- button5 ----
        button5.setText("\u8bfb\u8005\u7ba1\u7406");
        contentPane.add(button5);
        button5.setBounds(495, 200, 148, 30);
        button5.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ManageReader manageReader=new ManageReader(mname);
                        setVisible(false);
                        dispose();
                        manageReader.setVisible(true);
                    }
                }
        );

        //---- button6 ----
        button6.setText("\u9000\u51fa\u767b\u5f55");
        contentPane.add(button6);
        button6.setBounds(495, 300, 145, button6.getPreferredSize().height);
        button6.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        setVisible(false);
                        dispose();
                        LoginOrder loginOrder=new LoginOrder();
                        loginOrder.setVisible(true);
                    }
                }
        );

        //---- button7 ----
        button7.setText("\u6211\u7684\u8d44\u6599");
        contentPane.add(button7);
        button7.setBounds(495, 240, 145, button7.getPreferredSize().height);
        button7.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        String SetidSQL="SELECT mid FROM manages WHERE mname='"+mname+"'";
                        int mid1=0;
                        try {
                            LinkOracle linkOracle=new LinkOracle();
                            System.out.println(SetidSQL);
                            ResultSet rs = null;
                            linkOracle.LinkOracle();
                            rs = stmt.executeQuery(SetidSQL);
                            rs.next();
                            mid1=rs.getInt(1);
                            rs.close();
                        } catch (ClassNotFoundException e1) {
                            e1.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }finally {
                            try {
                                stmt.close();
                                conn.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        ManageDate manageDate=new ManageDate(mid1,mname);
                        setVisible(false);
                        dispose();
                        manageDate.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(650, 380));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Object[][] data = null;
    String[] head = {"书籍ID", "书籍名称", "作者", "书籍状态","所在地"};

    public Object[][] queryData() {
        List<books> booksList = new ArrayList<books>();
        System.out.println(sql);
        ResultSet rs = null;
        try {
            LinkOracle linkOracle=new LinkOracle();
            linkOracle.LinkOracle();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                books book=new books();
                book.setBid(rs.getString(1));
                book.setBname(rs.getString(3));
                book.setBauthor(rs.getString(4));
                book.setSname(rs.getString(2));
                book.setBhome(rs.getString(5));
                booksList.add(book);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                LinkOracle.conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[booksList.size()][head.length];
        for (int i = 0; i < booksList.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = booksList.get(i).getBid();
                data[i][1] = booksList.get(i).getBname();
                data[i][2] = booksList.get(i).getBauthor();
                data[i][3] = booksList.get(i).getSname();
                data[i][4] = booksList.get(i).getBhome();
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    JTable table1;
    private JTextField textField1;
    private JButton button1;
    private JComboBox comboBox1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
