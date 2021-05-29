package org.example.ui.login;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed Apr 28 18:00:37 CST 2021
 */



/**
 * @author 1
 */
public class successForm extends JFrame {
    public successForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u6210\u529f");
        contentPane.add(label1);
        label1.setBounds(70, 35, 70, 45);

        contentPane.setPreferredSize(new Dimension(225, 140));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
