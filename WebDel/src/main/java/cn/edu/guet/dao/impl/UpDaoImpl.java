package cn.edu.guet.dao.impl;

import cn.edu.guet.dao.UpDao;

import java.sql.*;

public class UpDaoImpl implements UpDao {
    @Override
    public void Updatebooks(int id,String bname,String bauthor,String bhome) {
        System.out.println("信息"+id+" "+bname+" "+bauthor+" "+bhome);
        String sqlUp="UPDATE books SET bname='"+bname+"',bauthor='"+bauthor+"',bhome='"+bhome+"' WHERE bid="+id;
        System.out.println(sqlUp);
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "chenyicai";
        String password = "cyc1234";
        Connection conn = null;
        Statement stmt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt=conn.createStatement();
            stmt.executeUpdate(sqlUp);
            System.out.println("修改成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
