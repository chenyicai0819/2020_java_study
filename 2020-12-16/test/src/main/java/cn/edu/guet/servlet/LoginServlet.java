package cn.edu.guet.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            查看用户
            删除用户
            修改用户
            新增用户
         */
        String uri=request.getRequestURI();
        System.out.println("访问路径："+uri);
        if(uri.contains("viewUser")){
            System.out.println("查看用户");
        }else if(uri.contains("deleteUser")){
            System.out.println("删除用户");
        }else if(uri.contains("updateUser")){
            System.out.println("更新用户");
        }else if(uri.contains("saveUser")){
            System.out.println("保存用户");
        }
        /*
        SpringMVC
        Spring
         */
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}