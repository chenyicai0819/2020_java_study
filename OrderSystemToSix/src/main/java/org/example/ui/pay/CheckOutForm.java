/*
 * Created by JFormDesigner on Tue Apr 27 09:13:38 GMT+08:00 2021
 */

package org.example.ui.pay;

import org.example.ui.pay.Orderdisher;
import org.example.ui.pay.Vips;
import org.example.ui.pay.GenerateException;
import org.example.ui.pay.Delete;
import org.example.ui.pay.Select;
import org.example.ui.pay.Update;
import org.example.ui.pay.GenerateQRCode;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 1
 */
public class CheckOutForm extends JFrame {
    public CheckOutForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField("1.0");
        textField3 = new JTextField();
        button2 = new JButton();
        textField4 = new JTextField();
        label4 = new JLabel();
        label5 = new JLabel();
        textField5 = new JTextField("0");
        final String Address="F:\\a蓝桥\\点餐系统\\QR\\";

        //======== this ========
        setTitle("\u7ed3\u8d26\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            List tid=new ArrayList();
            tid=Select.selectTid();
            data=new Object[tid.size()][1];
            for(int i=0;i<tid.size();i++){
                data[i][0]=tid.get(i);
            }
            String title[]={"桌号"};
            DefaultTableModel tableModel = new DefaultTableModel(data,title);
            table1.setModel(tableModel);
            scrollPane1.setViewportView(table1);
            data=null;
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 0, 400, scrollPane1.getPreferredSize().height);

        //---- 结账 ----
        button1.setText("\u7ed3\u8d26");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(430, 375), button1.getPreferredSize()));
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String vid=textField5.getText();
                        Vips vips=Select.selectVips(vid);
                        String price=textField1.getText();
                        //获取折扣，默认为1.0
                        String discount=textField2.getText();
                        if(!vid.equals(0)) {
                            if (vips.getVgrade().equals("1")) {
                                discount = "0.98";
                            } else if (vips.getVgrade().equals("2")) {
                                discount = "0.95";
                            } else if (vips.getVgrade().equals("3")) {
                                discount = "0.9";
                            } else if (vips.getVgrade().equals("4")) {
                                discount = "0.85";
                            } else if (vips.getVgrade().equals("5")) {
                                discount = "0.8";
                            }
                        }
                        textField2.setText(discount);
                        String totalAmount=String.format("%.2f",Double.valueOf(price)*Double.valueOf(discount));
                        textField3.setText(totalAmount);
                        try {
                            String picture = GenerateQRCode.test_trade_precreate(totalAmount, Address);
                            String tid = textField4.getText();
                            Drawing drawing=new Drawing(picture,vips,totalAmount,tid);
                        }catch(GenerateException ge){
                            ge.printStackTrace();
                            setVisible(false);
                            new CheckOutForm();
                        }
                    }
                }
        );
        //---- 该桌消费 ----
        label1.setText("\u8be5\u684c\u6d88\u8d39");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(430, 120), label1.getPreferredSize()));

        //---- 顾客折扣 ----
        label2.setText("\u987e\u5ba2\u6298\u6263");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(430, 240), label2.getPreferredSize()));

        //---- 顾客总消费 ----
        label3.setText("\u987e\u5ba2\u603b\u6d88\u8d39");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(430, 310), label3.getPreferredSize()));
        //该桌消费
        contentPane.add(textField1);
        textField1.setBounds(430, 150, 60, textField1.getPreferredSize().height);
        //顾客折扣
        contentPane.add(textField2);
        textField2.setBounds(430, 270, 60, textField2.getPreferredSize().height);
        //顾客总消费
        contentPane.add(textField3);
        textField3.setBounds(430, 340, 60, textField3.getPreferredSize().height);

        //---- 查询 ----
        button2.setText("\u67e5\u8be2");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(430, 75), button2.getPreferredSize()));
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //鼠标点击获取桌号
                        String getname;
                        if(textField4.getText().length()==0) {
                            int count = table1.getSelectedRow();//获取你选中的行号（记录）
                            getname = table1.getValueAt(count, 0).toString();//读取你获取行号的某一列的值（也就是字段）
                            textField4.setText(getname);
                        }
                        String tid=textField4.getText();
                        List<Orderdisher> list=new ArrayList<Orderdisher>();
                        list=Select.selectOrder(tid);
                        data=new Object[list.size()][head.length];
                        double money=0;
                        for (int i = 0; i < list.size(); i++) {
                            data[i][0] = list.get(i).getTid();
                            data[i][1] = list.get(i).getOid();
                            data[i][2] = list.get(i).getFname();
                            data[i][3] = list.get(i).getFmoney();
                            money=money+list.get(i).getFmoney();
                        }
                        DefaultTableModel tableModel = new DefaultTableModel(data,head);
                        table1.setModel(tableModel);
                        textField1.setText(String.valueOf(money));
                    }
                }
        );
        //桌号
        contentPane.add(textField4);
        textField4.setBounds(430, 35, 60, textField4.getPreferredSize().height);

        //---- 桌号 ----
        label4.setText("\u684c\u53f7");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(430, 15), label4.getPreferredSize()));

        //---- 会员id ----
        label5.setText("\u4f1a\u5458id");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(430, 190), label5.getPreferredSize()));
        //会员id
        contentPane.add(textField5);
        textField5.setBounds(430, 215, 60, textField5.getPreferredSize().height);

        contentPane.setPreferredSize(new Dimension(520, 450));
        pack();
        setLocationRelativeTo(getOwner());
        setVisible(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button2;
    private JTextField textField4;
    private JLabel label4;
    private JLabel label5;
    private JTextField textField5;
    private Object[][] data=null;
    private String head[]={"桌号","用餐号","菜品","总价"};
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
