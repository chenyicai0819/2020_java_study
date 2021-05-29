/*
 * Created by JFormDesigner on Wed May 19 00:27:15 CST 2021
 */

package Login;

import dao.LinkOracle;
import message.MD5;
import reader.ReaderShowDemo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;

import static dao.LinkOracle.stmt;

/**
 * @author 1
 */
public class ReaderLoginForm extends JFrame {
    public ReaderLoginForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField("cyc");
        label3 = new JLabel();
        textField2 = new JPasswordField("cyc1234");
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u9986\u8bfb\u8005\u767b\u5f55\u7cfb\u7edf");
        label1.setFont(label1.getFont().deriveFont(label1.getFont().getSize() + 6f));
        contentPane.add(label1);
        label1.setBounds(100, 5, 160, 35);

        //---- label2 ----
        label2.setText("\u7528\u6237\u540d\uff1a");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
        contentPane.add(label2);
        label2.setBounds(65, 65, 65, 30);
        contentPane.add(textField1);
        textField1.setBounds(140, 65, 120, 30);

        //---- label3 ----
        label3.setText("\u5bc6    \u7801\uff1a");
        label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
        contentPane.add(label3);
        label3.setBounds(65, 100, 65, 30);
        contentPane.add(textField2);
        textField2.setBounds(140, 100, 120, 30);

        //---- button1 ----
        button1.setText("\u767b\u5f55");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(65, 145, 195, 35);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String username=textField1.getText();
                        String password=textField2.getText();
                        String sql="SELECT rpwd FROM readers WHERE rname='"+username+"'";
                        System.out.println(sql);
                        ResultSet rs=null;
                        try {
                            LinkOracle linkOracle=new LinkOracle();
                            linkOracle.LinkOracle();
                            linkOracle.stmt=linkOracle.conn.createStatement();
                            rs=linkOracle.stmt.executeQuery(sql);
                            rs.next();
                            String encodePassword=rs.getString(1);
                            System.out.println(encodePassword);
                            System.out.println(MD5.encoderByMd5(password));
                            if(MD5.checkpassword(password,encodePassword)){
                                String SetidSQL="SELECT rid FROM readers WHERE rname='"+username+"'";
                                int rid1=0;
                                System.out.println(SetidSQL);
                                ResultSet rs2 = null;
                                rs2 = stmt.executeQuery(SetidSQL);
                                rs2.next();
                                rid1=rs2.getInt(1);
                                rs2.close();
                                System.out.println("登陆成功");
                                dispose();
                                ReaderShowDemo readerShowDemo=new ReaderShowDemo(rid1);
                                readerShowDemo.setVisible(true);
                            }else{
                                System.out.println("登陆失败");
                                Component jPanel = null;
                                JOptionPane.showMessageDialog(jPanel,
                                        "用户名或密码错误，请重新输入", "登陆失败", JOptionPane.WARNING_MESSAGE);
                            }
                        } catch (ClassNotFoundException ee) {
                            ee.printStackTrace();
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                            noSuchAlgorithmException.printStackTrace();
                        } catch (UnsupportedEncodingException unsupportedEncodingException) {
                            unsupportedEncodingException.printStackTrace();
                        } finally {
                            //释放资源：数据库连接很昂贵
                            try {
                                rs.close();
                                LinkOracle.stmt.close();
                                LinkOracle.conn.close();//关连接
                            } catch (SQLException throwables) {
                                throwables.printStackTrace();
                            }

                        }
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u6ce8\u518c");
        contentPane.add(button2);
        button2.setBounds(65, 180, 65, 25);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ReaderRegister readerRegister=new ReaderRegister();
                        readerRegister.setVisible(true);
                    }
                }
        );

        //---- button3 ----
        button3.setText("\u4fee\u6539\u5bc6\u7801");
        contentPane.add(button3);
        button3.setBounds(155, 180, 105, 25);
        button3.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ReaderUpdateForm readerUpdateForm=new ReaderUpdateForm();
                        readerUpdateForm.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(350, 265));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
