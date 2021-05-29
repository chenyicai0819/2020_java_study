/*
 * Created by JFormDesigner on Wed May 19 10:03:43 CST 2021
 */

package reader;

import dao.LinkOracle;
import service.ShowDemo;
import service.books;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ReaderBorrow extends JFrame {
    String sql ="SELECT * FROM books where sname='入藏' order by bid";
    public ReaderBorrow(int rid) {
        initComponents(rid);
    }

    private void initComponents(int rid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        textField1 = new JTextField();
        button1 = new JButton();
        comboBox1 = new JComboBox();
        button2 = new JButton();

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
        textField1.setBounds(15, 340, 160, textField1.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u641c\u7d22");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(265, 340, 80, 30);
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
                                sql="SELECT * FROM books WHERE bname like '%"+text1+"%' OR bauthor like '%"+text1+"%' and sname='入藏' order by bid";
                                DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table1.setModel(tableModel);
                            }else if(com1.equals("书名")){
                                sql="SELECT * FROM books WHERE bname like '%"+text1+"%' and sname='入藏' order by bid";
                                DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                    public boolean isCellEditable(int row, int column) {
                                        return false;
                                    }
                                };
                                table1.setModel(tableModel);
                            }else if(com1.equals("作者")){
                                sql="SELECT * FROM books WHERE bauthor like '%"+text1+"%' and sname='入藏' order by bid";
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
        comboBox1.setBounds(180, 340, 80, comboBox1.getPreferredSize().height);
        comboBox1.addItem("全部");
        comboBox1.addItem("书名");
        comboBox1.addItem("作者");

        //---- button2 ----
        button2.setText("\u6dfb\u52a0\u56fe\u4e66");
        contentPane.add(button2);
        button2.setBounds(350, 340, 125, button2.getPreferredSize().height);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        String get1 =table1.getValueAt(count, 0).toString();
                        String get2=table1.getValueAt(count,1).toString();
                        String get3=table1.getValueAt(count,2).toString();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Calendar c = Calendar.getInstance();
                        c.setTime(new Date());
                        c.add(Calendar.MONTH, 1);
                        Date m = c.getTime();
                        String mon = format.format(m);
                        ReaderAddBooks readerAddBooks=new ReaderAddBooks(get1,get2,get3,mon,rid);
                        setVisible(false);
                        dispose();
                        readerAddBooks.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(505, 420));
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
    private JTable table1;
    private JTextField textField1;
    private JButton button1;
    private JComboBox comboBox1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
