package cn.edu.guet.service.impl;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.LoginDao;
import cn.edu.guet.dao.impl.LoginDaoImpl;
import cn.edu.guet.service.LoginService;

public class LoginServiceImpl implements LoginService {
    @Override
    public User login(String username, String password) {
        LoginDao loginDao=new LoginDaoImpl();
        return loginDao.login(username,password);
    }
}
