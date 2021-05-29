/*
 * Created by JFormDesigner on Mon May 10 23:54:23 CST 2021
 */

package org.example.ui.viporders;

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
public class ViporderTableFrom extends JFrame {
    public ViporderTableFrom(String vipid) {
        initComponents(vipid);
    }

    private void initComponents(final String vipid) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        button1 = new JButton();
        label1 = new JLabel();

        //======== this ========
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(40, 40, 170, 280);

        //---- button1 ----
        button1.setText("\u9009\u62e9\u9910\u684c");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 3f));
        contentPane.add(button1);
        button1.setBounds(45, 325, 165, 30);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int Row = table1.getSelectedRow();//获取你选中的行号（记录）
                        int Column = table1.getSelectedColumn();
                        String orderT =table1.getValueAt(Row,Column).toString();
                        ViporderFoodForm viporderFoodForm=new ViporderFoodForm(orderT,vipid);
                        dispose();
                        viporderFoodForm.setVisible(true);
                    }
                }
        );

        //---- label1 ----
        label1.setText("\u4f1a\u5458\u70b9\u9910\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 10f));
        contentPane.add(label1);
        label1.setBounds(55, 5, 170, label1.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(255, 400));
        pack();
        setLocationRelativeTo(getOwner());
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

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private Object[][] data = null;
    private String head[] = {"桌号"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
