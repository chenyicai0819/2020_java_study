package org.example.dao;

import java.sql.*;

/**
 * JDBC连接数据库
 */

public class LinkOracle {
    public static Connection conn=null;
    public static Statement stmt=null;
    public static PreparedStatement pstt=null;

    public void LinkOracle() throws ClassNotFoundException, SQLException {
        String url="jdbc:oracle:thin:@8.129.212.155:1521:orcl";
        String user="dcxt";
        String pass="dcxt1234";
		//不要在这个账户里创建其他与项目无关的表
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn= DriverManager.getConnection(url,user,pass);
        stmt=conn.createStatement();

    }

}
