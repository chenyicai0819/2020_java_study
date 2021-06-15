package cn.edu.guet.dao.impl;

import cn.edu.guet.dao.InsDao;

import java.sql.*;

public class InsDaoImpl implements InsDao {
    @Override
    public void insertBook(int id, String sname, String bname, String bauthor, String bhome) {
        System.out.println("信息"+id+" "+sname+" "+bname+" "+bauthor+" "+bhome);
        String AddSQL="INSERT INTO books VALUES(?,?,?,?,?)";
        System.out.println(AddSQL);
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "chenyicai";
        String password = "cyc1234";
        Connection conn = null;
        PreparedStatement pstt=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            pstt=conn.prepareStatement(AddSQL);
            pstt.setObject(1,id);
            pstt.setObject(2,sname);
            pstt.setObject(3,bname);
            pstt.setObject(4,bauthor);
            pstt.setObject(5,bhome);
            pstt.executeUpdate();
            System.out.println("添加成功");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                pstt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
