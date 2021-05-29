/*
 * Created by JFormDesigner on Fri May 14 22:29:22 CST 2021
 */

package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author 1
 */
public class LoginOrder extends JFrame {
    public static void main(String[] args) {
        new LoginOrder();
    }
    public LoginOrder() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("\u5de5\u4f5c\u4eba\u5458\u767b\u5f55");
        button1.setFont(button1.getFont().deriveFont(button1.getFont().getSize() + 5f));
        contentPane.add(button1);
        button1.setBounds(25, 50, 150, 50);
        button1.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        UserLoginForm userLoginForm=new UserLoginForm();
                        setVisible(false);
                        dispose();
                        userLoginForm.setVisible(true);
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u4f1a\u5458\u767b\u5f55");
        button2.setFont(button2.getFont().deriveFont(button2.getFont().getSize() + 5f));
        contentPane.add(button2);
        button2.setBounds(25, 115, 150, 50);
        button2.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ReaderLoginForm readerLoginForm=new ReaderLoginForm();
                        setVisible(false);
                        dispose();
                        readerLoginForm.setVisible(true);
                    }
                }
        );

        contentPane.setPreferredSize(new Dimension(215, 255));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
