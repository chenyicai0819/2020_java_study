package cn.edu.guet.servlet;

import cn.edu.guet.bean.User;
import cn.edu.guet.service.LoginService;
import cn.edu.guet.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        LoginService loginService=new LoginServiceImpl();
        User user=loginService.login(username,password);
        request.setAttribute("user",user);
        request.getRequestDispatcher("./jsp/index.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
