package cn.edu.guet.service;

import cn.edu.guet.bean.User;

public interface LoginService {
    User login(String username, String password);
}
