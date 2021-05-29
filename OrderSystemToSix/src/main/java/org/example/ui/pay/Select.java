package org.example.ui.pay;

import org.example.ui.pay.Orderdisher;
import org.example.ui.pay.Vips;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select {
    public static List selectTid() {
        List tid=new ArrayList();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;
        String sql = "SELECT DISTINCT(tid) FROM orderdisher";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            System.out.println("连接：" + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                tid.add(rs.getString(1));
            }
            return tid;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return tid;
    }
    public static List<Orderdisher> selectOrder(String tid) {
        List<Orderdisher> list=new ArrayList<Orderdisher>();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;
        String sql = "SELECT * FROM orderdisher WHERE tid="+tid;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            System.out.println("连接：" + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Orderdisher orderdisher =new Orderdisher();
                orderdisher.setOid(rs.getInt("oid"));
                orderdisher.setFid(rs.getString("fid"));
                orderdisher.setTid(rs.getInt("tid"));
                orderdisher.setFname(rs.getString("fname"));
                orderdisher.setFmoney(rs.getDouble("fmoney"));
                list.add(orderdisher);
            }
            return list;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return list;
    }

    public static Vips selectVips(String vid) {
        Vips vips=new Vips();
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt = null;
        String sql = "SELECT * FROM vips WHERE vid="+vid;
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            System.out.println("连接：" + conn);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
           if(rs.next()) {
               vips.setVid(rs.getInt("vid"));
               vips.setVname(rs.getString("vname"));
               vips.setVgrade(rs.getString("vgrade"));
               vips.setVintegral(rs.getDouble("vintegral"));
           }
            return vips;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return vips;
    }
}