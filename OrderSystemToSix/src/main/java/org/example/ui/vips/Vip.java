package org.example.ui.vips;

import org.example.message.MD5;
import org.example.ui.login.rSuccessForm;

import javax.swing.*;
import java.awt.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Random;

public class Vip {
    private String vid;
    private String vpassword;
    private String vname;
    private String vphone;
    private int vintegral;

    Vip(){
    }
    public Vip(String a, String b, String c, int d){
        this.vid = a;
        this.vname = b;
        this.vphone = c;
        this.vintegral = d;
    }
    public Vip(ResultSet rs){
        try {
            this.vid = rs.getString("vid");
            this.vname = rs.getString("vname");
            this.vpassword = rs.getString("vpassword");
            this.vphone = rs.getString("vphone");
            this.vintegral = rs.getInt("vintegral");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    public static ResultSet getVipResultSet(String str){
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM VIPS WHERE vid= ? ";
        ResultSet rs = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, str);
            pstmt.execute();
            rs = pstmt.getResultSet();
            rs.next();
            return rs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
     */

    /*
    public static boolean checkId_Pwd(String id, String pwd){
        boolean flag = false;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM VIPS WHERE vid = ? and vpassword = ?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.execute();
            ResultSet rs = pstmt.getResultSet();
            if(rs.next()){
                flag = true;
            };
            return flag;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return flag;
    }
     */

    public static ResultSet getResultSet(String id, String pwd){
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM VIPS WHERE vname = ? and vpassword = ?";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.execute();
            rs = pstmt.getResultSet();
            return rs;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rs;
    }

    public static void vipUpdate(Vip vip, boolean flag1, boolean flag2){
        if(flag1 || flag2) {
            Connection conn = null;
            PreparedStatement pstmt = null;
            String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
            String sql1 = "UPDATE VIPS SET vphone=? WHERE vid=?";
            String sql2 = "UPDATE VIPS SET vpassword=? WHERE vid=?";
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(url, "dcxt", "dcxt1234");
                if(flag1){
                    pstmt = conn.prepareStatement(sql1);
                    pstmt.setString(1, vip.getVphone());
                    pstmt.setString(2, vip.getVid());
                    pstmt.executeUpdate();
                }else if(flag2){
                    pstmt = conn.prepareStatement(sql2);
                    pstmt.setString(1, MD5.encoderByMd5(vip.getVpassword()));
                    pstmt.setString(2, vip.getVid());
                    pstmt.executeUpdate();
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } finally {
                try {
                    pstmt.close();
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }

    public static boolean registerVip(String vname, String vpassword, String vphone){
        boolean flag = false;
        boolean checkFlag = false;
        Connection conn = null;
        String url = "jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        String sql = "INSERT INTO VIPS VALUES(?, ?, ?, ?, 0, 0)";
        String idSql = "SELECT VID FROM VIPS";
        String nameSql = "SELECT VNAME FROM VIPS";
        Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int vid = (int)(Math.random()*100000);
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url,"dcxt","dcxt1234");
            stmt = conn.createStatement();
            pstmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery(nameSql);
            while (rs.next()){
                if(rs.getString("VNAME").equals(vname)){
                    checkFlag = true;
                }
            }
            if(checkFlag){
                flag = false;
            }else{
                rs = stmt.executeQuery(idSql);
                while (rs.next()) {
                    if (rs.getInt("VID") == vid) {
                        vid = (int) (Math.random() * 100000);
                    }
                }
                pstmt.setInt(1, vid);
                pstmt.setString(2, vname);
                pstmt.setString(3, MD5.encoderByMd5(vpassword));
                pstmt.setString(4, vphone);
                if (pstmt.executeUpdate() == 1) {
                    flag = true;
                }
            }
            return flag;
        } catch (ClassNotFoundException | SQLException ee) {
            ee.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            //释放资源：数据库连接很昂贵
            try {
                stmt.close();
                conn.close();
                pstmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return flag;
    }

    public static int getGrage(int a){
        if(a >= 0 && a < 200){
            return 1;
        }else if(a >= 200 && a < 400){
            return 2;
        }else if(a >= 400 && a < 600) {
            return 3;
        }else if(a >= 600 && a < 800) {
            return 4;
        }else if(a >= 800) {
            return 5;
        }
        return 0;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getVphone() {
        return vphone;
    }

    public void setVphone(String vphone) {
        this.vphone = vphone;
    }

    public int getVintegral() {
        return vintegral;
    }

    public void setVintegral(int vintegral) {
        this.vintegral = vintegral;
    }

    public String getVpassword(){
        return vpassword;
    }

    public void setVpassword(String vpassword){
        this.vpassword = vpassword;
    }
}