package com.swl.servlet;

import com.swl.bean.User;
import com.swl.dao.FavoriteDao;
import com.swl.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/FavoriteValidateServlet")
public class FavoriteValidateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置request编码方式
        request.setCharacterEncoding("UTF-8");
        //设置response编码方式
        response.setContentType("text/html;charset=UTF-8");
        //获取客户端传来的favoriteName
        String favoriteName = request.getParameter("favoriteName");
        //通过session判断是否登录，未登录则要求用户进行登录
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null) {
            // TODO 登录操作，完成后返回到此页
        }
        //获取response的打印流
        PrintWriter pw = response.getWriter();
        //判断收藏夹名是否重复并向客户端发送信息
        if (new FavoriteDao().selectFavoriteNameCount(((User)(session.getAttribute("user"))).getUserId(), favoriteName) > 0) {
            pw.write("false");
        } else {
            pw.write("true");
        }
        //刷新并关闭打印流
        pw.flush();
        pw.close();
    }
}
