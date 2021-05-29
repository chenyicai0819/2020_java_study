package org.example.ui.queues;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/*
 * Created by JFormDesigner on Wed Apr 28 14:52:02 GMT+08:00 2021
 */


/**
 * @author 1
 */
public class QueuingSystem extends JFrame {
    java.util.List<Queue> list=new ArrayList<Queue>();

    public void QueuingSystem() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setModel(tableModel);
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField(""+list.size()+"");
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(170, 50, 275, 240);

        //---- label1 ----
        label1.setText("\u6b63\u5728\u6392\u961f\u7684\u987e\u5ba2");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 19f));
        contentPane.add(label1);
        label1.setBounds(180, 5, 240, label1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u6b63\u5728\u6392\u961f\u7684\u4eba\u6570\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(170, 300), label2.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(270, 295), textField1.getPreferredSize()));

        //---- button1 ----排号
        button1.setText("\u6392\u53f7");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(460, 230), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override

                    public void actionPerformed(ActionEvent actionEvent) {
                        int ID =1;
                        if(list.size()>0) {
                            ID=list.get(list.size() - 1).getId() + 1;
                        }
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt = null;//SQL语句对象，拼SQL
                        String sql = "INSERT INTO queues VALUES('"+ID+"')";
                        System.out.println("即将执行的sql：" + sql);
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            stmt = conn.createStatement();
                            stmt.executeQuery(sql);
                            list.clear();
                            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                            textField1.setText(String.valueOf(list.size()));





                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                stmt.close();
                                conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );


        //---- button2 ----叫号
        button2.setText("\u53eb\u53f7");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(460, 260), button2.getPreferredSize()));
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Connection conn = null;
                        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
                        Statement stmt = null;//SQL语句对象，拼SQL
                        String sql1="SELECT min(qid) FROM queues";
                        System.out.println(sql1);
                        ResultSet rs=null;
                        String sql2 = "DELETE FROM queues WHERE qid=(SELECT min(qid) FROM queues)";
                        System.out.println(sql2);
                        try {
                            Class.forName("oracle.jdbc.driver.OracleDriver");//
                            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                            stmt = conn.createStatement();
                            rs=stmt.executeQuery(sql1);
                            rs.next();
                            String minQid= String.valueOf(rs.getInt(1));
                            FileWriter fw=null;
                            fw=new FileWriter("F:\\a蓝桥\\点餐系统\\语音播报\\叫号.txt");
                            String Intxt="请"+minQid+"号顾客用餐";
                            fw.write(Intxt);
                            fw.flush();
                            System.out.println("生成txt");

                            Voice.voice();
                            stmt.executeQuery(sql2);
                            list.clear();
                            DefaultTableModel tableModel = new DefaultTableModel(queryData(), head) {
                                public boolean isCellEditable(int row, int column) {
                                    return false;
                                }
                            };
                            table1.setModel(tableModel);
                            textField1.setText(String.valueOf(list.size()));

                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                stmt.close();
                                conn.close();//关连接
                                rs.close();
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }
                        }
                    }
                }
        );

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
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public Object[][] queryData() {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;//SQL语句对象，拼SQL
        String sql = "SELECT * FROM queues order by qid";
        System.out.println("即将执行的sql：" + sql);
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Queue queue = new Queue();
                queue.setId(rs.getInt("qid"));
                list.add(queue);
            }
            System.out.println(list.size());

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
        //把集合里的数据放入Obejct这个二维数组
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();


            }
        }
        return data;
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private Object[][] data = null;
    private String head[] = {"排队序号"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
