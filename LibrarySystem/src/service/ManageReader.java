/*
 * Created by JFormDesigner on Wed May 19 15:58:49 CST 2021
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
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ManageReader extends JFrame {
    public ManageReader(String mname) {
        initComponents(mname);
    }

    private void initComponents(String mname) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

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
        scrollPane1.setBounds(5, 5, 315, 180);

        //---- button1 ----
        button1.setText("\u501f\u9605\u67e5\u8be2");
        contentPane.add(button1);
        button1.setBounds(5, 190, 90, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        int get1 = (int) table1.getValueAt(count, 0);
                        ManageReaderBooks manageReaderBooks=new ManageReaderBooks(get1,mname);
                        setVisible(false);
                        dispose();
                        manageReaderBooks.setVisible(true);
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u5bc6\u7801\u91cd\u7f6e");
        contentPane.add(button2);
        button2.setBounds(115, 190, 90, 35);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int count = table1.getSelectedRow();//获取你选中的行号（记录）
                        int get1 = (int) table1.getValueAt(count, 0);

                        LinkOracle linkOracle=new LinkOracle();
                        try {
                            String Md5Password= MD5.encoderByMd5("111111");
                            linkOracle.LinkOracle();
                            String upsql="UPDATE readers SET rpwd='"+Md5Password+"' WHERE rid="+get1;
                            int a=stmt.executeUpdate(upsql);
                            if(a==1){
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "成功重置密码为:111111，请提醒用户及时修改", "重置成功", JOptionPane.INFORMATION_MESSAGE);
                            }else{
                                Component jPanel1 = null;
                                JOptionPane.showMessageDialog(jPanel1, "发生错误", "发生错误", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        } finally {
                            try {
                                stmt.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );

        //---- button3 ----
        button3.setText("   ");
        contentPane.add(button3);
        button3.setBounds(225, 190, 90, 35);

        contentPane.setPreferredSize(new Dimension(330, 270));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Object[][] data = null;
    String[] head = {"用户ID", "用户名","用户密码"};

    public Object[][] queryData() {
        List<readers> readersList = new ArrayList<readers>();
        String sql = "SELECT * FROM readers";
        System.out.println(sql);
        ResultSet rs = null;
        try {
            LinkOracle linkOracle = new LinkOracle();
            linkOracle.LinkOracle();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                readers reader = new readers();
                reader.setRid(rs.getInt(1));
                reader.setRname(rs.getString(2));
                reader.setRpwd(rs.getString(3));
                readersList.add(reader);
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
        data = new Object[readersList.size()][head.length];
        for (int i = 0; i < readersList.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = readersList.get(i).getRid();
                data[i][1] = readersList.get(i).getRname();
                data[i][2] = readersList.get(i).getRpwd();
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
