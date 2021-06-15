package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public List<User> viewUser(String sel) {
        /*
        具体的JDBC代码，连接数据库，获取数据
         */
        String sql="";
        if(sel==null||sel==""){
            sql = "SELECT * FROM books";
        }else{
            sql = "SELECT * FROM books WHERE bname like '%"+sel+"%'";
        }
        System.out.println(sql);
        List<User> userList = new ArrayList<User>();
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "chenyicai";
        String password = "cyc1234";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                User users=new User();
                users.setBid(rs.getString(1));
                users.setSname(rs.getString(2));
                users.setBname(rs.getString(3));
                users.setBauthor(rs.getString(4));
                users.setBhome(rs.getString(5));
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }
}
