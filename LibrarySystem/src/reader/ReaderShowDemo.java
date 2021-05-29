/*
 * Created by JFormDesigner on Wed May 19 00:41:38 CST 2021
 */

package reader;

import Login.LoginOrder;
import dao.LinkOracle;
import service.books;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class ReaderShowDemo extends JFrame {
    public ReaderShowDemo(int rid) {
        initComponents(rid);
    }

    private void initComponents(int rid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
            DefaultTableModel tableModel = new DefaultTableModel(queryData(rid), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 10, 460, 240);

        //---- button1 ----
        button1.setText("\u501f\u4e66");
        contentPane.add(button1);
        button1.setBounds(15, 260, 95, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ReaderBorrow readerBorrow=new ReaderBorrow(rid);
                        setVisible(false);
                        dispose();
                        readerBorrow.setVisible(true);
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u8fd8\u4e66");
        contentPane.add(button2);
        button2.setBounds(115, 260, 95, 35);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        String get1 =table1.getValueAt(count, 0).toString();
                        String get2=table1.getValueAt(count,1).toString();
                        String get3=table1.getValueAt(count,2).toString();
                        String get4=table1.getValueAt(count,3).toString();
                        ReaderReturnBooks readerReturnBooks=new ReaderReturnBooks(get1,get2,get3,get4,rid);
                        setVisible(false);
                        dispose();
                        readerReturnBooks.setVisible(true);
                    }
                }
        );

        //---- button3 ----
        button3.setText("\u6211\u7684\u8d44\u6599");
        contentPane.add(button3);
        button3.setBounds(315, 260, 95, 35);
        final String[] rname1 = new String[1];
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        LinkOracle linkOracle=new LinkOracle();
                        ResultSet rs=null;
                        try {
                            linkOracle.LinkOracle();
                            String selesql="SELECT rname FROM readers WHERE rid="+rid;
                            rs=stmt.executeQuery(selesql);
                            rs.next();
                            rname1[0] =rs.getString(1);
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            try {
                                stmt.close();
                                rs.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                        ReaderManageDate readerManageDate=new ReaderManageDate(rid,rname1[0]);
                        setVisible(false);
                        dispose();
                        readerManageDate.setVisible(true);
                    }
                }
        );

        //---- button4 ----
        button4.setText("\u7eed\u501f");
        contentPane.add(button4);
        button4.setBounds(215, 260, 95, 35);
        button4.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        String get1 =table1.getValueAt(count, 0).toString();
                        String get2=table1.getValueAt(count,1).toString();
                        String get3=table1.getValueAt(count,2).toString();
                        String get4=table1.getValueAt(count,3).toString();
                        LinkOracle linkOracle=new LinkOracle();
                        try {
                            ResultSet rs=null;
                            linkOracle.LinkOracle();
                            String selsql="SELECT rno FROM renew WHERE bid='"+get1+"'";
                            rs=stmt.executeQuery(selsql);
                            rs.next();
                            int aa=rs.getInt(1);
                            if(aa==1){
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "已续借过一次，不能再续借", "续借失败", JOptionPane.ERROR_MESSAGE);
                            }else{
                                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                                Calendar c = Calendar.getInstance();
                                c.setTime(new Date());
                                c.add(Calendar.MONTH, 1);
                                Date m = c.getTime();
                                String mon = format.format(m);
                                ReaderRenewBooks readerRenewBooks=new ReaderRenewBooks(get1,get2,get3,mon,rid);
                                setVisible(false);
                                dispose();
                                readerRenewBooks.setVisible(true);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }

                    }
                }
        );

        //---- button5 ----
        button5.setText("exit");
        contentPane.add(button5);
        button5.setBounds(415, 260, 60, 35);
        button5.addActionListener(
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

        contentPane.setPreferredSize(new Dimension(500, 365));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Object[][] data = null;
    String[] head = {"书籍ID", "书籍名称", "作者","归还日期"};

    public Object[][] queryData(int rid) {
        List<readbooks> readbooksList = new ArrayList<readbooks>();
        String sql="select books.*,readerbook.rbtime from books,readerbook where books.bid=readerbook.bid and readerbook.rid="+rid+"";
        System.out.println(sql);
        ResultSet rs = null;
        try {
            LinkOracle linkOracle=new LinkOracle();
            linkOracle.LinkOracle();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                readbooks readbook=new readbooks();
                readbook.setBid(rs.getInt(1));
                readbook.setBname(rs.getString(3));
                readbook.setBauthor(rs.getString(4));
                readbook.setRbtime(rs.getString(6));
                readbooksList.add(readbook);
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
        data = new Object[readbooksList.size()][head.length];
        for (int i = 0; i < readbooksList.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = readbooksList.get(i).getBid();
                data[i][1] = readbooksList.get(i).getBname();
                data[i][2] = readbooksList.get(i).getBauthor();
                data[i][3] = readbooksList.get(i).getRbtime();

            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
