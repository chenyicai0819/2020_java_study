package org.example.ui.login;

import java.awt.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Fri May 07 22:23:01 CST 2021
 */



/**
 * @author 1
 */
public class rSuccessForm extends JFrame {
    public rSuccessForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6ce8\u518c\u6210\u529f\uff01");
        contentPane.add(label1);
        label1.setBounds(140, 100, 100, 35);

        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
