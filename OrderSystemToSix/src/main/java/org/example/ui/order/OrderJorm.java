package org.example.ui.order;

import org.example.ui.order.Foods;
import org.example.ui.order.Tables;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Sat May 08 22:44:55 CST 2021
 */



/**
 * @author 1
 */
public class OrderJorm extends JFrame {
    public void OrderJForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        final String[] orderT = {""};
        JMenu menu1 = new JMenu("查看餐桌");
        JMenu menu2 = new JMenu("点餐");
        scrollPane1 = new JScrollPane();
        table1 = new JTable();//餐桌表
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        scrollPane2 = new JScrollPane();
        table2 = new JTable();//点菜表
        DefaultTableModel tableModel1 = new DefaultTableModel(queryData1(), head1) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table2.setModel(tableModel1);
        button1 = new JButton();//选择按钮
        label1 = new JLabel();//桌号
        textField1 = new JTextField();//填写桌号
        label2 = new JLabel();//欢迎登录点菜系统
        button2 = new JButton();//刷新按钮
        button3=new JButton();//选择餐桌按钮

        //======== this ========
        setTitle("\u70b9\u83dc");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== 查看餐桌 ========
            {
                menu1.setText("\u67e5\u770b\u9910\u684c");
            }
            menuBar1.add(menu1);
            menu1.addMenuListener(
                    new MenuListener() {
                        @Override
                        public void menuSelected(MenuEvent e) {

                        }

                        @Override
                        public void menuDeselected(MenuEvent e) {
                            label1.setVisible(false);
                            textField1.setVisible(false);
                            button1.setVisible(false);
                            button3.setVisible(true);
                            scrollPane2.setVisible(false);
                            table2.setVisible(false);
                            label2.setVisible(false);
                            scrollPane1.setVisible(true);
                            table1.setVisible(true);
                            button2.setVisible(true);

                        }

                        @Override
                        public void menuCanceled(MenuEvent e) {

                        }
                    }
            );

            //======== menu2 ========
            {
                menu2.setText("\u70b9\u9910");
            }
            menuBar1.add(menu2);
            menu2.addMenuListener(
                    new MenuListener() {
                        @Override
                        public void menuSelected(MenuEvent e) {

                        }

                        @Override
                        public void menuDeselected(MenuEvent e) {
                            button2.setVisible(false);
                            table1.setVisible(false);
                            scrollPane1.setVisible(false);
                            label2.setVisible(false);
                            scrollPane2.setVisible(true);
                            table2.setVisible(true);
                            button1.setVisible(true);
                            label1.setVisible(true);
                            textField1.setVisible(true);
                            button3.setVisible(false);
                        }

                        @Override
                        public void menuCanceled(MenuEvent e) {

                        }
                    }
            );
        }
        setJMenuBar(menuBar1);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(175, 25, 305, 190);
        scrollPane1.setVisible(false);
        table1.setVisible(false);

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(table2);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(85, 15, 435, 225);
        scrollPane2.setVisible(false);
        table2.setVisible(false);

        //---- 选择按钮 ----
        button1.setText("选择");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(555, 75), button1.getPreferredSize()));
        button1.setVisible(false);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String tid=textField1.getText();
                        int count=table2.getSelectedRow();
                        String fid=table2.getValueAt(count,0).toString();
                        String fname=table2.getValueAt(count,1).toString();
                        String fmoney=table2.getValueAt(count,2).toString();

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
                    }
                }
        );

        button3.setText("选择");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(555, 105), button3.getPreferredSize()));
        button3.setVisible(false);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int Row = table1.getSelectedRow();//获取你选中的行号（记录）
                        int Column = table1.getSelectedColumn();
                        orderT[0] =table1.getValueAt(Row,Column).toString();
                        System.out.println(orderT[0]);
                        button2.setVisible(false);
                        table1.setVisible(false);
                        scrollPane1.setVisible(false);
                        label2.setVisible(false);
                        scrollPane2.setVisible(true);
                        table2.setVisible(true);
                        button1.setVisible(true);
                        label1.setVisible(true);
                        textField1.setVisible(true);
                        button3.setVisible(false);
                        textField1.setText(""+orderT[0]+"");
                    }
                }
        );

        //---- 桌号 ----

        label1.setText("\u684c\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(550, 30, 50, 30);
        contentPane.add(textField1);
        textField1.setBounds(600, 30, 50, 30);
        label1.setVisible(false);
        textField1.setVisible(false);

        //---- 欢迎登录点餐系统 ----
        label2.setText("\u6b22\u8fce\u767b\u5f55\u70b9\u83dc\u7cfb\u7edf");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 30f));
        contentPane.add(label2);
        label2.setBounds(140, 75, 370, 100);

        //---- 刷新按钮 ----
        button2.setText("\u5237\u65b0");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(495, 60), button2.getPreferredSize()));
        button2.setVisible(false);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        };
                        table1.setModel(tableModel);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(670, 385));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public Object[][] queryData() {
        java.util.List<Tables> list=new ArrayList<Tables>();//建立一个List集合容器，用以存放从数据库中得到的数据
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT tid FROM tables WHERE tid NOT IN(SELECT DISTINCT(tid) FROM orderdisher)";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                Tables dt=new Tables();
                dt.setTid(rs.getInt("tid"));
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

        data = new Object[list.size()][head.length];
        //把集合中的数据放入Object这个数组中
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getTid();
            }
        }
        return data;
    }

    public Object[][] queryData1() {
        java.util.List<Foods> list=new ArrayList<Foods>();//建立一个List集合容器，用以存放从数据库中得到的数据
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql1 = "SELECT * FROM foods";
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

    static int oid = 0;
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JButton button1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private Object[][] data = null;
    private String head[] = {"桌号"};
    private Object[][] data1 = null;
    private String head1[] = {"菜名ID","菜名","价格","菜系"};
}
