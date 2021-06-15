package cn.edu.guet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request=(HttpServletRequest)req;
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
        if(username!=null || "".equals(username)){
            chain.doFilter(req, resp);
        }
        else{
            HttpServletResponse response=(HttpServletResponse)resp;
            response.sendRedirect("login.html?text1=%E8%AF%B7%E7%99%BB%E5%BD%95");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
