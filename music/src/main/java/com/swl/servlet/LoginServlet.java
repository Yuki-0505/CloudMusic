package com.swl.servlet;

import com.swl.bean.User;
import com.swl.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//      获取前端传来的字段 email password
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//      封装对象
        UserDao userDao = new UserDao();
        User user = userDao.getUserByEmailAndPassword(email, password);
//      判断登陆是否成功
        if (user != null) {
//          成功，重定向到主页
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {
//          失败，重定向到登录页
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }
}
