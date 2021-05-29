package org.example.ui.xmb;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Tue May 11 14:54:36 CST 2021
 */



/**
 * @author 1
 */
public class Profit extends JFrame {
    public Profit() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        label2 = new JLabel();
        comboBox2 = new JComboBox();
        label3 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2=new JTextField("0");

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        DefaultTableModel tableModel = new DefaultTableModel(queryData(),head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        table1.setRowHeight(30);
        comboBox1.addItem(2021);
        comboBox1.addItem(2020);
        comboBox1.addItem(2019);
        comboBox2.addItem(12);
        comboBox2.addItem(11);
        comboBox2.addItem(10);
        comboBox2.addItem(9);
        comboBox2.addItem(8);
        comboBox2.addItem(7);
        comboBox2.addItem(6);
        comboBox2.addItem(5);
        comboBox2.addItem(4);
        comboBox2.addItem(3);
        comboBox2.addItem(2);
        comboBox2.addItem(1);

        //---- label1 ----
        label1.setText("\u5229\u6da6\u67e5\u8be2");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 22f));
        contentPane.add(label1);
        label1.setBounds(230, 25, 160, 35);
        contentPane.add(comboBox1);
        comboBox1.setBounds(145, 80, 100, 25);

        //---- label2 ----
        label2.setText("\u5e74");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 4f));
        contentPane.add(label2);
        label2.setBounds(260, 80, 40, 25);
        contentPane.add(comboBox2);
        comboBox2.setBounds(340, 80, 100, 25);

        //---- label3 ----
        label3.setText("\u6708");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 4f));
        contentPane.add(label3);
        label3.setBounds(455, 80, 40, 25);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(110, 120, 395, 213);

        //---- button1 ----按年查询
        button1.setText("\u6309\u5e74\u67e5\u8be2");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 4f));
        contentPane.add(button1);
        button1.setBounds(75, 390, 105, 30);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt = null;
                        String sql = "select sum(TOTALMONEY) tm from recode where extract(year from RDAY)=" + comboBox1.getSelectedItem();
                        System.out.println("即将执行的sql：" + sql);
                        ResultSet rs = null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                            rs.next();
                            // 在方框中输出利润
                            double sumPrice = rs.getDouble("tm");
                            textField1.setText(String.valueOf(sumPrice));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );
        //---- button2 ----按月查询
        button2.setText("\u6309\u6708\u67e5\u8be2");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 4f));
        contentPane.add(button2);
        button2.setBounds(265, 390, 105, 30);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt = null;
                        String sql = "select sum(TOTALMONEY) tm from recode where extract(year from RDAY)="+comboBox1.getSelectedItem()+
                                " and extract(month from RDAY)="+comboBox2.getSelectedItem();
                        System.out.println("即将执行的sql：" + sql);
                        ResultSet rs = null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                            rs.next();
                            // 在方框中输出利润
                            double sumPrice = rs.getDouble("tm");
                            textField1.setText(String.valueOf(sumPrice));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        //---- button3 ----按日查询
        button3.setText("\u6309\u65e5\u67e5\u8be2");
        button3.setFont(button3.getFont().deriveFont(button3.getFont().getSize() + 4f));
        contentPane.add(button3);
        button3.setBounds(460, 390, 105, 30);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt = null;
                        table1.addMouseListener(
                                new MouseListener() {
                                    @Override
                                    public void mouseClicked(MouseEvent mouseEvent) {
                                        int row = table1.getSelectedRow();
                                        int column = table1.getSelectedColumn();
                                        selectedDays = (int) table1.getValueAt(row, column);
                                        textField2.setText(String.valueOf(selectedDays));
                                    }
                                    @Override
                                    public void mousePressed(MouseEvent mouseEvent) { }
                                    @Override
                                    public void mouseReleased(MouseEvent mouseEvent) { }
                                    @Override
                                    public void mouseEntered(MouseEvent mouseEvent) { }
                                    @Override
                                    public void mouseExited(MouseEvent mouseEvent) { }
                                }
                        );
                        String sql = "select sum(TOTALMONEY) tm from recode where extract(year from RDAY)="+comboBox1.getSelectedItem()+
                                " and extract(month from RDAY)="+comboBox2.getSelectedItem()+" and extract(day from RDAY)="+
                                selectedDays;
                        System.out.println("即将执行的sql：" + sql);
                        ResultSet rs = null;
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(sql);
                            rs.next();
                            // 在方框中输出利润
                            double sumPrice = rs.getDouble("tm");
                            textField1.setText(String.valueOf(sumPrice));
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }
        );


        //---- label4 ----
        label4.setText("\u5229\u6da6\uff1a");
        label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 8f));
        contentPane.add(label4);
        label4.setBounds(195, 350, 65, 25);
        contentPane.add(textField1);
        textField1.setBounds(255, 350, 120, 26);
        contentPane.add(textField2);
        textField2.setBounds(460, 350, 50, 20);


        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public Object[][] queryData() {
        data = new Object[6][6];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                data[i][j] = j + 1 + i*6;
            }
        }
        data[5][0] = 31;
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JComboBox comboBox1;
    private JLabel label2;
    private JComboBox comboBox2;
    private JLabel label3;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private Object[][] data = null;
    private String head[] = {"   ","   ","   ","   ","   ","   "};
    static int selectedDays;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
