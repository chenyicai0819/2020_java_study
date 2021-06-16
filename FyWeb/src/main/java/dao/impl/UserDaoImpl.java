package dao.impl;



import bean.User;
import dao.IUserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    int totalPage=1;
    int pageSize=1;
    @Override

    public List<User> viewUser(int curPage) {

        String sql="";


        int start=(curPage-1)*pageSize;
        sql = "SELECT * FROM books limit "+start+","+pageSize;

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

    @Override
    public int totalPage() {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";
        String username = "chenyicai";
        String password = "cyc1234";
        Connection conn = null;
        String sql1 = "SELECT COUNT(*) FROM books";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            pstmt = conn.prepareStatement(sql1);
            rs = pstmt.executeQuery();
            rs.next();
            int totalRows = rs.getInt(1);
            if (totalRows % pageSize == 0) {
                totalPage = totalRows / pageSize;
            } else {
                totalPage = (totalRows / pageSize) + 1;
            }
        }catch (SQLException e) {
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
        return totalPage;
    }
}

