package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Role;
import cn.edu.guet.bean.Tree;
import cn.edu.guet.bean.User;
import cn.edu.guet.dao.LoginDao;

import java.sql.*;

public class LoginDaoImpl implements LoginDao {

    @Override
    public User login(String username,String password) {
        String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=gbk&autoReconnect=true&failOverReadOnly=false&serverTimezone=UTC";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM tb_user WHERE username=? AND password=?";
        User user=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, "chenyicai", "cyc1234");
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                user=new User();
                user.setUserId(rs.getString("USERID"));
                user.setUsername(rs.getString("USERNAME"));
                user.setRealName(rs.getString("REALNAME"));

                sql="SELECT r.* FROM tb_user_role ur,tb_role r WHERE r.roleid=ur.roleid AND ur.userid=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getUserId());
                rs=pstmt.executeQuery();
                while(rs.next()){
                    Role role=new Role();
                    role.setRoleId(rs.getString("ROLEID"));
                    role.setRoleName(rs.getString("ROLENAME"));
                    user.getRoleList().add(role);
                }
                sql="SELECT tree.* FROM tb_role_permission rp,tb_tree tree WHERE tree.TreeId=rp.TreeId AND rp.RoleId=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, user.getRoleList().get(0).getRoleId());
                rs=pstmt.executeQuery();
                while(rs.next()){
                    Tree tree=new Tree();
                    tree.setTreeId(rs.getString("TREEID"));
                    tree.setParentId(rs.getString("PARENTID"));
                    tree.setTitle(rs.getString("TITLE"));
                    tree.setUrl(rs.getString("URL"));
                    tree.setIsParent(rs.getString("ISPARENT"));
                    user.getRoleList().get(0).getTreeList().add(tree);
                }
            } else {
                System.out.println("登陆失败");
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
        return user;
    }
}
