package com.swl.servlet;

import com.swl.bean.User;
import com.swl.dao.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(urlPatterns = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//      获取前台提交的email userName password
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
//      封装数据对象
        User user = new User(null, userName, password, null, email, null, null, 0, new Date());
        UserDao userDao = new UserDao();
        //      保存user到数据库
//      注册
        if(userDao.registerUser(user)) {
//          注册成功，跳转到登陆
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        } else {
//          失败
            response.sendRedirect(request.getContextPath() + "/register.jsp");
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/register.html");
//            dispatcher.forward(request, response);
        }
    }
}
