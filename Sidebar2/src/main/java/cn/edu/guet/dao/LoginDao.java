package cn.edu.guet.dao;

import cn.edu.guet.bean.User;

public interface LoginDao {
    User login(String username, String password);
}
