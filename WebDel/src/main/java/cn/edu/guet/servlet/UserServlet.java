package cn.edu.guet.servlet;

import cn.edu.guet.bean.User;
import cn.edu.guet.dao.DelDao;
import cn.edu.guet.dao.IUserDao;
import cn.edu.guet.dao.InsDao;
import cn.edu.guet.dao.UpDao;
import cn.edu.guet.dao.impl.DelDaoImpl;
import cn.edu.guet.dao.impl.InsDaoImpl;
import cn.edu.guet.dao.impl.UpDaoImpl;
import cn.edu.guet.dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri=request.getRequestURI();
        System.out.println("url: "+uri);
        if(uri.endsWith("login")){
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            System.out.println("账号是"+ username);
            System.out.println("密码是"+ password);

            if("zhangsan".equals(username)&&"zs1234".equals(password)){

                HttpSession session=request.getSession();
                session.setAttribute("username",username);
                IUserDao userDao=new UserDaoImpl();
                List<User> userList=userDao.viewUser("");

                request.setAttribute("userList",userList);
                request.getRequestDispatcher("/books/main.jsp").forward(request,response);

            }else {
                response.sendRedirect("login.html?text1=%E8%B4%A6%E5%8F%B7%E6%88%96%E8%80%85%E5%AF%86%E7%A0%81%E9%94%99%E8%AF%AF");
            }
        }else if (uri.endsWith("user.do")){
            String selete = request.getParameter("selete");
            System.out.println("查找名"+selete);

            IUserDao userDao=new UserDaoImpl();
            List<User> userList=userDao.viewUser(selete);

            request.setAttribute("userList",userList);
            request.setAttribute("selete",selete);
            request.getRequestDispatcher("/books/main.jsp").forward(request,response);
        }else if (uri.endsWith("update.do")){
            String bid=request.getParameter("bid");
            String bname=request.getParameter("bname");
            String bauthor=request.getParameter("bauthor");
            String bhome=request.getParameter("bhome");
            System.out.println("信息"+bid+" "+bname+" "+bauthor+" "+bhome);

            UpDao upDao=new UpDaoImpl();
            upDao.Updatebooks(Integer.parseInt(bid),bname,bauthor,bhome);

            IUserDao userDao=new UserDaoImpl();
            List<User> userList=userDao.viewUser("");
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/books/main.jsp").forward(request,response);
        }else if (uri.endsWith("insert.do")){
            String bid=request.getParameter("bid");
            String sname="入藏";
            String bname=request.getParameter("bname");
            String bauthor=request.getParameter("bauthor");
            String bhome=request.getParameter("bhome");
            System.out.println("信息"+bid+" "+sname+" "+bname+" "+bauthor+" "+bhome);

            InsDao insDao=new InsDaoImpl();
            insDao.insertBook(Integer.parseInt(bid),sname,bname,bauthor,bhome);

            IUserDao userDao=new UserDaoImpl();
            List<User> userList=userDao.viewUser("");
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/books/main.jsp").forward(request,response);
        }else if (uri.endsWith("delete.do")){
            String did=request.getParameter("delID");
            System.out.println(did);

            DelDao delDao=new DelDaoImpl();
            delDao.DelBook(did);

            IUserDao userDao=new UserDaoImpl();
            List<User> userList=userDao.viewUser("");
            request.setAttribute("userList",userList);
            request.getRequestDispatcher("/books/main.jsp").forward(request,response);
        }

    }
}
