/*
 * Created by JFormDesigner on Wed Apr 28 14:44:11 CST 2021
 */

package org.example.ui.managefoods;

import org.example.dao.LinkOracle;
import org.example.service.Read;
import org.example.service.foods;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.dao.LinkOracle.stmt;

/**
 * @author 1
 */

public class ShowFoods extends JFrame {
    static String aa = "";
    int totalPage = 1;

    int rowsPerPage = 10;//每页几条记录
    int currentPage = 1;
    int endRow = rowsPerPage;
    int startRow = currentPage;
    Read read = new Read();
    String currentPage1 = "";
    String getname1, getname3, getname2, getname4;
    List<String> UpList = new ArrayList<String>();
    String sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;


    public void ShowFoods() {
        initComponents();

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        currentPage = totalPage;
        endRow = rowsPerPage * currentPage;
        startRow = (currentPage - 1) * rowsPerPage + 1;
        sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        textField5.setText(String.valueOf(currentPage));
    }

    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        currentPage = currentPage + 1;

        if (currentPage > totalPage) {
            Component jPanel = null;
            JOptionPane.showMessageDialog(jPanel, "已经是最后一页了", "提示", JOptionPane.ERROR_MESSAGE);
        } else {
            endRow = rowsPerPage * currentPage;
            startRow = (currentPage - 1) * rowsPerPage + 1;
            sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            textField5.setText(String.valueOf(currentPage));
        }
    }

    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        currentPage = 1;
        endRow = rowsPerPage * currentPage;
        startRow = (currentPage - 1) * rowsPerPage + 1;
        sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        textField5.setText(String.valueOf(currentPage));
    }

    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        currentPage = currentPage - 1;
        if (currentPage < 1) {
            Component jPanel = null;
            JOptionPane.showMessageDialog(jPanel, "已经是第一页了", "提示", JOptionPane.ERROR_MESSAGE);
        } else {
            endRow = rowsPerPage * currentPage;
            startRow = (currentPage - 1) * rowsPerPage + 1;
            sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            textField5.setText(String.valueOf(currentPage));
        }
    }

    private void button7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        new AddFoods().AddFoods();
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        String foodid;
        int count = table1.getSelectedRow();//获取你选中的行号（记录）
        getname1 = table1.getValueAt(count, 1).toString();
        getname2 = table1.getValueAt(count, 2).toString();
        getname3 = table1.getValueAt(count, 3).toString();
        getname4 = table1.getValueAt(count, 4).toString();
        textField3.setText(getname1);
        foodid=getname1;
        textField4.setText(getname2);
        textField2.setText(getname3);
        textField1.setText(getname4);
        new ReFoods().ReFoods(foodid);

    }

    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        int count = table1.getSelectedRow();//获取你选中的行号（记录）
        getname1 = table1.getValueAt(count, 1).toString();
        getname2 = table1.getValueAt(count, 2).toString();
        getname3 = table1.getValueAt(count, 3).toString();
        getname4 = table1.getValueAt(count, 4).toString();
        textField3.setText(getname1);
        textField4.setText(getname2);
        textField2.setText(getname3);
        textField1.setText(getname4);
        String gettext1 = textField3.getText();
        String gettext2 = textField4.getText();
        Component jPanel = null;
        int delete1 = JOptionPane.showConfirmDialog(jPanel, "是否要删除" + gettext2 + "这个菜品", "注意", JOptionPane.YES_NO_OPTION);
        if (delete1 == 0) {
            //点了是
            LinkOracle linkOracle = new LinkOracle();
            String deletesql = "DELETE FROM foods WHERE fid='" + gettext1 + "'";
            System.out.println(deletesql);
            try {
                linkOracle.LinkOracle();
                int deleteOK = stmt.executeUpdate(deletesql);
                if (deleteOK == 1) {
                    Component jPanel1 = null;
                    JOptionPane.showMessageDialog(jPanel1, "成功删除了" + gettext2 + "这个菜品", "删除成功", JOptionPane.ERROR_MESSAGE);
                }
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    LinkOracle.conn.close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

        } else if (delete1 == 1) {
            //点了否
            Component jPanel2 = null;
            JOptionPane.showMessageDialog(jPanel2, "取消了删除", "删除失败", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void button8ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (comboBox1.getSelectedItem() == "全部") {
            sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            textField6.setText(String.valueOf(totalPage));
        } else {
            String comBox1get = (String) comboBox1.getSelectedItem();
            sql = "SELECT * FROM (SELECT rownum rn,t.* FROM (SELECT * FROM foods WHERE fclass='" + comBox1get + "' ORDER BY fclass) t WHERE rownum<=" + endRow + ") WHERE rn>=" + startRow;
            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
            table1.setModel(tableModel);
            textField6.setText(String.valueOf(totalPage));
        }

    }
    
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        panel1 = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        label6 = new JLabel();
        button8 = new JButton();
        comboBox1 = new JComboBox();


        //======== this ========
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u663e\u793a\u6240\u6709\u83dc\u54c1");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(245, 5), label1.getPreferredSize()));

        //======== panel1 ========
        {
            panel1.setLayout(null);

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
            panel1.add(scrollPane1);
            scrollPane1.setBounds(0, 0, 495, 185);

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(new Rectangle(new Point(50, 30), panel1.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u5c3e\u9875");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1ActionPerformed(e);
            }
        });
        contentPane.add(button1);
        button1.setBounds(470, 255, 78, 30);

        //---- button2 ----
        button2.setText("\u4e0b\u4e00\u9875");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button2ActionPerformed(e);
            }
        });
        contentPane.add(button2);
        button2.setBounds(385, 255, 78, 30);

        //---- button3 ----
        button3.setText("\u4e0a\u4e00\u9875");
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button3ActionPerformed(e);
            }
        });
        contentPane.add(button3);
        button3.setBounds(300, 255, 78, 30);

        //---- button4 ----
        button4.setText("\u9996\u9875");
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button4ActionPerformed(e);
            }
        });
        contentPane.add(button4);
        button4.setBounds(215, 255, 78, 30);

        //---- label2 ----
        label2.setText("\u5f53\u524d\u9875\u6570");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 260), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u603b\u9875\u6570");
        contentPane.add(label3);
        label3.setBounds(135, 260, 48, 17);

        //---- button5 ----
        button5.setText("\u5220\u9664\u83dc\u54c1");
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button5ActionPerformed(e);
            }
        });
        contentPane.add(button5);
        button5.setBounds(460, 295, 88, 30);

        //---- button6 ----
        button6.setText("\u4fee\u6539\u4ef7\u683c");
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button6ActionPerformed(e);
            }
        });
        contentPane.add(button6);
        button6.setBounds(360, 295, 88, 30);

        //---- button7 ----
        button7.setText("\u6dfb\u52a0\u83dc\u54c1");
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button7ActionPerformed(e);
            }
        });
        contentPane.add(button7);
        button7.setBounds(260, 295, 88, 30);

        //---- textField1 ----
        textField1.setEditable(false);
        contentPane.add(textField1);
        textField1.setBounds(455, 220, 89, 30);

        //---- textField2 ----
        textField2.setEditable(false);
        contentPane.add(textField2);
        textField2.setBounds(355, 220, 89, 30);

        //---- textField3 ----
        textField3.setEditable(false);
        contentPane.add(textField3);
        textField3.setBounds(155, 220, 89, 30);

        //---- textField4 ----
        textField4.setEditable(false);
        contentPane.add(textField4);
        textField4.setBounds(255, 220, 89, 30);

        //---- label6 ----
        label6.setText("\u9009\u4e2d\u4fe1\u606f\uff1a");
        contentPane.add(label6);
        label6.setBounds(55, 225, 85, 25);

        //---- button8 ----
        button8.setText("\u5237\u65b0\u9875\u9762");
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button8ActionPerformed(e);
            }
        });
        contentPane.add(button8);
        button8.setBounds(160, 295, 88, 30);
        contentPane.add(comboBox1);
        comboBox1.setBounds(65, 295,80,30);
        comboBox1.addItem("全部");
        comboBox1.addItem("素菜");
        comboBox1.addItem("荤菜");
        comboBox1.addItem("汤类");
        comboBox1.addItem("酒水");
        comboBox1.addItem("面食");
        comboBox1.addItem("主食");
        textField5 = new JTextField(""+currentPage+"");
        contentPane.add(textField5);
        textField5.setBounds(100, 260, 30, 20);
        contentPane.add(textField6);
        textField6.setBounds(175, 260, 30, 20);


        contentPane.setPreferredSize(new Dimension(590, 380));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private Object[][] data = null;
    private String head[] = {"序号", "菜品号", "菜品名称", "价格", "菜品类别"};

    public Object[][] queryData() {
        List<foods> foodsList = new ArrayList<foods>();

        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                foods food = new foods();
                food.setFno(rs.getInt(1));
                food.setFid(rs.getString(2));
                food.setFname(rs.getString(3));
                food.setFmoney(rs.getInt(4));
                food.setFclass(rs.getString(5));
                foodsList.add(food);
            }
            String sql1 = "SELECT COUNT(*) FROM foods";
            rs = stmt.executeQuery(sql1);
            rs.next();
            int totalRows = rs.getInt(1);
            if (totalRows % rowsPerPage == 0) {
                totalPage = totalRows / rowsPerPage;
            } else {
                totalPage = (totalRows / rowsPerPage) + 1;
            }

            textField6 = new JTextField(""+totalPage+"");

            //System.out.println(list.size());
        } catch (ClassNotFoundException ee) {
            ee.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        data = new Object[foodsList.size()][head.length];
        for (int i = 0; i < foodsList.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = foodsList.get(i).getFno();
                data[i][1] = foodsList.get(i).getFid();
                data[i][2] = foodsList.get(i).getFname();
                data[i][3] = foodsList.get(i).getFmoney();
                data[i][4] = foodsList.get(i).getFclass();
            }
        }
        return data;


    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JPanel panel1;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel label2;
    private JLabel label3;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel label6;
    private JButton button8;
    private JComboBox comboBox1;
    private JTextField textField5;
    private JTextField textField6;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
