package org.example.ui.vips;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 28 12:54:11 CST 2021
 */



/**
 * @author 1
 */
public class ChangeInf extends JFrame {
    public ChangeInf(Vip vip) {
        this.setPreferredSize(new Dimension(400, 400));
        initComponents(vip);
    }

    private void initComponents(final Vip vip) {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        setResizable(false);
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);


        //---- label1 ----
        label1.setText("\u5bc6\u7801");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 120), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u7535\u8bdd\u53f7\u7801");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(40, 60), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(40, 170), label3.getPreferredSize()));

        contentPane.add(textField1);
        textField1.setBounds(105, 55, 145, textField1.getPreferredSize().height);
        textField1.setText(vip.getVphone());

        contentPane.add(textField2);
        textField2.setBounds(100, 115, 150, textField2.getPreferredSize().height);
        contentPane.add(textField3);
        textField3.setBounds(100, 165, 160, textField3.getPreferredSize().height);

        //---- 确定 ----
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(65, 235), button1.getPreferredSize()));
        button1.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String newPassword1 = textField2.getText();
                        String newPassword2 = textField3.getText();
                        if(!newPassword1.equals(newPassword2)){
                            JOptionPane.showMessageDialog(null, "密码不一致", "错误", JOptionPane.ERROR_MESSAGE);
                        }else{
                            boolean flag1 = false;
                            boolean flag2 = false;
                            if(!textField1.getText().equals(vip.getVphone())){
                                vip.setVphone(textField1.getText());
                                flag1 = true;
                            }
                            if(textField2.getText().length() != 0){
                                vip.setVpassword(textField2.getText());
                                flag2 = true;
                            }
                            VipForm.update(vip, flag1, flag2);
                            dispose();
                        }
                    }
                }
        );

        //---- button2 ----
        button2.setText("\u53d6\u6d88");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(255, 235), button2.getPreferredSize()));

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
        contentPane.setPreferredSize(new Dimension(215, 210));
        pack();
        setLocationRelativeTo(getOwner());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
