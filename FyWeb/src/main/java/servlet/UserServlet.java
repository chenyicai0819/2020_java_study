package servlet;


import bean.User;
import dao.IUserDao;
import dao.impl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        System.out.println("url: " + uri);


        String curPage = request.getParameter("curPage");
        if (curPage == null) {
            curPage = "1";
        }
        int nowPage = Integer.parseInt(curPage);
        IUserDao userDao = new UserDaoImpl();
        List<User> userList = userDao.viewUser(Integer.parseInt(curPage));
        int totoaPage=userDao.totalPage();

        request.setAttribute("nowPage", nowPage);
        request.setAttribute("userList", userList);
        request.setAttribute("totalPage",totoaPage);
        request.getRequestDispatcher("/books/main.jsp").forward(request, response);
    }

}
