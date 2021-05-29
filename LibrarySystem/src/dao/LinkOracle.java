package dao;

import java.sql.*;

/**
 * JDBC连接数据库
 */

public class LinkOracle {
    public static Connection conn=null;
    public static Statement stmt=null;
    public static PreparedStatement pstt=null;

    public void LinkOracle() throws ClassNotFoundException, SQLException {
        /**
         * 虚拟机地址
         */
        //String url="jdbc:oracle:thin:@192.168.220.134:1521:orcl";
        //String user="liwei";
        //String pass="lw1234";
        /**
         * 阿里云地址
         */
        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        String user= "cyc";
        String pass="cyc1234";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn= DriverManager.getConnection(url,user,pass);
        stmt=conn.createStatement();

    }

}
