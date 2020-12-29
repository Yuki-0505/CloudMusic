package com.swl.servlet;

import com.swl.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/EmailValidateServlet")
public class EmailValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置response编码方式
        response.setContentType("text/html;charset=UTF-8");
        //获取客户端传来的email
        String email = request.getParameter("email");
        //获取response的打印流
        PrintWriter pw = response.getWriter();
        //判断邮箱是否重复并向客户端发送信息
        if (new UserDao().selectUserEmailCount(email) > 0) {
            pw.write("false");
        } else {
            pw.write("true");
        }
        //刷新并关闭打印流
        pw.flush();
        pw.close();
    }
}

