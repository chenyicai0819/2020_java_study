package org.example.ui.pay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Delete {

    public static void DeleteOrder(String tid) {
        Connection conn=null;
        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        Statement stmt=null;//SQL语句对象
        String sql="DELETE FROM orderdisher WHERE tid="+tid;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");//
            conn= DriverManager.getConnection(url,"dcxt","dcxt1234");
            System.out.println("连接："+conn);//如果conn不是null，则连接成功
            stmt=conn.createStatement();
            int a=stmt.executeUpdate(sql);//a=1
            System.out.println("删除了:"+a+"条");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        finally {
            try {
                stmt.close();
                conn.close();//关连接
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
