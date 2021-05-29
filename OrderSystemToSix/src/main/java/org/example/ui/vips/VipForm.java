package org.example.ui.vips;

import org.example.message.MD5;
import org.example.ui.viporders.ViporderTableFrom;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 28 12:20:41 CST 2021
 */



/**
 * @author 1
 */
public class VipForm extends JFrame {
    public VipForm(Vip vip) {
        this.setPreferredSize(new Dimension(400, 400));
        initComponents(vip);
    }

    private void initComponents(final Vip vip) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        vid = new JLabel();
        vname = new JLabel();
        vphone = new JLabel();
        vint = new JLabel();
        grade = new JLabel();
        button1 = new JButton();
        button2=new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        vid.setText("会员ID：" + vip.getVid());
        contentPane.add(vid);
        vid.setBounds(new Rectangle(new Point(35, 40), vid.getPreferredSize()));

        vname.setText("会员名称：" + vip.getVname());
        contentPane.add(vname);
        vname.setBounds(new Rectangle(new Point(35, 60), vname.getPreferredSize()));

        vphone.setText("电话号码：" + vip.getVphone());
        contentPane.add(vphone);
        vphone.setBounds(new Rectangle(new Point(35, 80), vphone.getPreferredSize()));

        vint.setText("积分：" + String.valueOf(vip.getVintegral()));
        contentPane.add(vint);
        vint.setBounds(new Rectangle(new Point(35, 100), vint.getPreferredSize()));


        grade.setText("等级：" + Vip.getGrage(vip.getVintegral()));
        contentPane.add(grade);
        grade.setBounds(new Rectangle(new Point(35, 120), grade.getPreferredSize()));

        //----- 修改资料 ----
        button1.setText("修改资料");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(35, 140), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new ChangeInf(vip);
                    }
                }
        );

        //点餐，陈益财
        button2.setText("点餐");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(35, 180), button2.getPreferredSize()));
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ViporderTableFrom viporderTableFrom=new ViporderTableFrom(vip.getVid());
                        viporderTableFrom.setVisible(true);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    public static void update(Vip vip, boolean flag1, boolean flag2){
        vphone.setText("电话号码：" + vip.getVphone());
        Vip.vipUpdate(vip, flag1, flag2);
    }



    private JLabel vid;
    private JLabel vname;
    private static JLabel vphone;
    private JLabel vint;
    private JLabel grade;
    private JButton button1;
    private JButton button2;

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
