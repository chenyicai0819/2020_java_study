package cn.edu.guet.dao.impl;

import cn.edu.guet.dao.DelDao;

import java.sql.*;

public class DelDaoImpl implements DelDao {

    @Override
    public void DelBook(String id) {
        System.out.println("删除"+id);
        String delsql = "DELETE FROM books WHERE bid="+id;
        System.out.println(delsql);
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "chenyicai";
        String password = "cyc1234";
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            stmt=conn.createStatement();
            stmt.executeUpdate(delsql);
            System.out.println("删除成功");
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
