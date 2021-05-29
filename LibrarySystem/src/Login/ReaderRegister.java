/*
 * Created by JFormDesigner on Wed May 19 00:30:36 CST 2021
 */

package Login;

import dao.LinkOracle;
import message.MD5;
import service.ShowDemo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ReaderRegister extends JFrame {
    public ReaderRegister() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();
        label4 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) { }
            @Override
            public void windowClosing(WindowEvent e) {
                ReaderLoginForm readerLoginForm=new ReaderLoginForm();
                readerLoginForm.setVisible(true);
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

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u9875\u9762");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u65b0\u7528\u6237\u540d\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(50, 85), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u65b0\u5bc6\u7801\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(55, 125), label3.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(125, 75, 175, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField2.setBounds(125, 120, 175, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
        contentPane.add(button1);
        button1.setBounds(145, 170, 120, 30);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();
                        String password=textField2.getText();
                        String md5password = "";
                        try {
                            md5password= MD5.encoderByMd5(password);
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        }
                        int radom = (int)(Math.random()*10000000);

                        String sql="INSERT INTO readers VALUES ('"+radom+"','"+username+"','"+md5password+"')" ;
                        System.out.println(sql);
                        ResultSet rs=null;
                        try {
                            LinkOracle linkOracle=new LinkOracle();
                            linkOracle.LinkOracle();
                            String selesql="SELECT rname FROM readers";
                            rs = stmt.executeQuery(selesql);
                            int a2=0;
                            while (rs.next()) {
                                String a1=rs.getString(1);
                                if(a1.equals(username)){
                                    a2++;
                                }
                            }
                            if(a2==0){
                                linkOracle.stmt=linkOracle.conn.createStatement();
                                rs=linkOracle.stmt.executeQuery(sql);
                                if(rs.next()){
                                    System.out.println("注册成功");
                                    setVisible(false);
                                    Component jPanel = null;
                                    JOptionPane.showMessageDialog(jPanel, "注册成功,您的ID为"+radom, "注册成功", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }else{
                                a2=0;
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel, "这个用户名已经存在，请更换一个", "注册失败", JOptionPane.ERROR_MESSAGE);
                            }

                        } catch (ClassNotFoundException | SQLException ee) {
                            ee.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                rs.close();
                                stmt.close();
                                LinkOracle.conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(55, 175), label4.getPreferredSize()));

        contentPane.setPreferredSize(new Dimension(400, 290));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
