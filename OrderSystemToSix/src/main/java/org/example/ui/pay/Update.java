package org.example.ui.pay;

import org.example.ui.pay.Vips;
import org.example.ui.viporders.VippayForm;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Update {
    public static void addvint(Vips vips, String vintegral) {
        Connection conn=null;
        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt=null;//SQL语句对象
        String sql="UPDATE vips SET vintegral=vintegral+? WHERE vid=?";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn= DriverManager.getConnection(url,"dcxt","dcxt1234");
            pstmt=conn.prepareStatement(sql);
            double jifen=Double.valueOf(vintegral)*0.1;
            pstmt.setDouble(1,jifen);
            pstmt.setInt(2,vips.getVid());
            pstmt.executeUpdate();
            System.out.println("会员积分增加："+jifen);
            Component jPanel = null;
            JOptionPane.showMessageDialog(jPanel, "付款成功！积分增加了"+jifen, "支付成功", JOptionPane.INFORMATION_MESSAGE);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                pstmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
    public static void Addrecode(Vips vips,String totalmoney) {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;//SQL语句对象
        String sql = "INSERT INTO recode VALUES(?,?,?,?)";
        String rid=createUUID.createID();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, rid);
            pstmt.setInt(2, vips.getVid());
            pstmt.setDouble(3, Double.valueOf(totalmoney));
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sdf.format(new Date());
            String nowDate=date.valueOf(date);
            pstmt.setTimestamp(4, Timestamp.valueOf(nowDate));
            pstmt.executeUpdate();
            System.out.println("订单:"+rid+" 生成成功！");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
