/*
 * Created by JFormDesigner on Tue May 11 00:05:53 CST 2021
 */

package org.example.ui.viporders;

import org.example.dao.LinkOracle;
import org.example.ui.order.Foods;
import org.example.ui.order.Tables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author 1
 */
public class ViporderFoodForm extends JFrame {
    String sql1 = "SELECT * FROM foods";
    int oid = 0;
    int money=0;
    int Allmoney=0;
    public ViporderFoodForm(String TableNo,String vipid) {
        initComponents(TableNo,vipid);
    }

    private void initComponents(final String TableNo,final String vipid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+TableNo+"");
        textField1.setEditable(false);
        button1 = new JButton();
        comboBox1 = new JComboBox();
        button2 = new JButton();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        textField2 = new JTextField();
        textField3=new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        label5=new JLabel();

        button3 = new JButton();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(15, 40, 405, 285);

        //---- label1 ----
        label1.setText("\u9009\u62e9\u60a8\u7684\u83dc\u54c1");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 8f));
        contentPane.add(label1);
        label1.setBounds(25, 10, 170, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u60a8\u7684\u684c\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(305, 10, 80, 25);
        contentPane.add(textField1);
        textField1.setBounds(380, 10, 40, 25);

        //---- button1 ----
        button1.setText("\u9009\u62e9");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(305, 335, 115, 40);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tid=textField1.getText();
                        int count=table1.getSelectedRow();
                        String fid=table1.getValueAt(count,0).toString();
                        String fname=table1.getValueAt(count,1).toString();
                        String fmoney=table1.getValueAt(count,2).toString();

                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        PreparedStatement pstmt = null;//SQL语句对象，拼SQL
                        String sql = "INSERT INTO orderdisher VALUES (?,?,?,?,?)";
                        System.out.println("即将执行的sql：" + sql);
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            pstmt =conn.prepareStatement(sql);
                            pstmt.setString(1, String.valueOf(oid));
                            pstmt.setString(2, fid);
                            pstmt.setString(3, tid);
                            pstmt.setString(4, fname);
                            pstmt.setString(5, fmoney);
                            oid++;
                            pstmt.executeUpdate();//修改数据
                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                pstmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                        DefaultTableModel tableModel = new DefaultTableModel(queryData2(), head2) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table2.setModel(tableModel);
                        LinkOracle linkOracle=new LinkOracle();
                        int total=0;
                        try {

                            String sql3="SELECT COUNT(*) FROM orderdisher WHERE tid='" + TableNo + "'";
                            Connection conn1 = null;
                            String url1 = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                            Statement stmt1 = null;//SQL语句对象，拼SQL
                            System.out.println("即将执行的sql：" + sql3);
                            ResultSet rs1 = null;
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn1 = DriverManager.getConnection(url1, "dcxt", "dcxt1234");
                            stmt1 = conn1.createStatement();
                            rs1 = stmt1.executeQuery(sql3);
                            rs1.next();
                            total = rs1.getInt(1);
                        } catch (ClassNotFoundException classNotFoundException) {
                            classNotFoundException.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                        Allmoney=0;
                        for(int i=0;i<total;i++){
                            money= Integer.parseInt(table2.getValueAt(i,1).toString());
                            Allmoney=Allmoney+money;
                        }
                        textField2.setText(""+Allmoney+"");
                    }
                }
        );

        contentPane.add(comboBox1);
        comboBox1.setBounds(10, 335, 80, 30);
        comboBox1.addItem("全部");
        comboBox1.addItem("素菜");
        comboBox1.addItem("荤菜");
        comboBox1.addItem("汤类");
        comboBox1.addItem("酒水");
        comboBox1.addItem("面食");
        comboBox1.addItem("主食");

        //---- button2 ----
        button2.setText("\u5237\u65b0");
        contentPane.add(button2);
        button2.setBounds(95, 335, 80, 30);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (comboBox1.getSelectedItem() == "全部") {
                            sql1 = "SELECT * FROM foods ORDER BY fclass";
                            DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                        } else {
                            String comBox1get = (String) comboBox1.getSelectedItem();
                            sql1 = "SELECT * FROM foods WHERE fclass='" + comBox1get + "' ORDER BY fclass";
                            DefaultTableModel tableModel = new DefaultTableModel(queryData1(), head1) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                        }
                    }
                }
        );

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(425, 40, 235, 285);

        //---- label3 ----
        label3.setText("\u60a8\u7684\u83dc\u54c1");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(495, 15, 85, label3.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u603b\u4ef7\uff1a");
        contentPane.add(label4);
        label4.setBounds(430, 340, 50, 25);
        contentPane.add(textField2);
        textField2.setBounds(475, 335, 45, textField2.getPreferredSize().height);

        //---- label5 ----
        label5.setText("欢迎您");
        contentPane.add(label5);
        label5.setBounds(180, 10, 70, label5.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(230, 10, 60, 25);
        textField3.setEditable(false);
        textField3.setText(""+vipid+"");
        //---- button3 ----
        button3.setText("\u5b8c\u6210\u70b9\u5355");
        contentPane.add(button3);
        button3.setBounds(565, 335, 80, 30);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        VippayForm vippayForm=new VippayForm(vipid,TableNo);
                        dispose();
                        vippayForm.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(670, 415));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] queryData1() {
        java.util.List<Foods> list=new ArrayList<Foods>();//建立一个List集合容器，用以存放从数据库中得到的数据
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        System.out.println("即将执行的sql：" + sql1);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql1);
            while (rs.next()){
                Foods dt=new Foods();
                dt.setFid(rs.getString("fid"));
                dt.setFname(rs.getString("fname"));
                dt.setFmoney(rs.getInt("fmoney"));
                dt.setFclass(rs.getString("fclass"));
                list.add(dt);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        data1 = new Object[list.size()][head1.length];
        //把集合中的数据放入Object这个数组中
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head1.length; j++) {
                data1[i][0] = list.get(i).getFid();
                data1[i][1] = list.get(i).getFname();
                data1[i][2] = list.get(i).getFmoney();
                data1[i][3] = list.get(i).getFclass();
            }
        }
        return data1;
    }

    public Object[][] queryData2() {
        java.util.List<Foods> list=new ArrayList<Foods>();//建立一个List集合容器，用以存放从数据库中得到的数据
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql2 = "SELECT * FROM orderdisher WHERE tid='"+textField1.getText()+"'";
        System.out.println("即将执行的sql：" + sql2);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql2);
            while (rs.next()){
                Foods dt=new Foods();
                dt.setFname(rs.getString("fname"));
                dt.setFmoney(rs.getInt("fmoney"));
                list.add(dt);
            }
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                rs.close();
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

        data2 = new Object[list.size()][head2.length];
        //把集合中的数据放入Object这个数组中
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head1.length; j++) {
                data2[i][0] = list.get(i).getFname();
                data2[i][1] = list.get(i).getFmoney();

            }
        }


        return data2;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JComboBox comboBox1;
    private JButton button2;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField2;
    private JButton button3;
    private JTextField textField3;
    private Object[][] data1 = null;
    private String head1[] = {"菜名ID","菜名","价格","菜系"};
    private Object[][] data2 = null;
    private String head2[] = {"菜名","价格"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
