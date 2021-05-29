package org.example.ui.pay;
import org.example.ui.pay.Vips;
import org.example.ui.pay.Delete;
import org.example.ui.pay.Update;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class Drawing {
    JFrame jframe = new JFrame();
    public static JPanel GImage =null;
    public Drawing(String filename, Vips vips,String totalAmount,String tid) {
        initFrame(filename,vips,totalAmount,tid);
    }
// 初始化窗口
    public void initFrame(final String filename, final Vips vips, final String totalAmount, final String tid) {
// 利用JPanel添加背景图片
        GImage = new JPanel() {
            protected void paintComponent(Graphics g) {
                ImageIcon icon = new ImageIcon(filename);
                Image img = icon.getImage();
                g.drawImage(img,0,0,icon.getIconWidth(), icon.getIconHeight(),icon.getImageObserver());
                jframe.setSize(300,300);

            }
        };
        jframe.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        //增加订单
                        Update.Addrecode(vips,totalAmount);
                        //付款结束，删除点菜表
                        Delete.DeleteOrder(tid);
                        //增加会员积分
                        Update.addvint(vips, totalAmount);
                    }
                }
        );
        jframe.setTitle("收款码");
        jframe.add(GImage);
        jframe.pack();
        jframe.setLocationRelativeTo(jframe.getOwner());
        jframe.setVisible(true);
    }
}
