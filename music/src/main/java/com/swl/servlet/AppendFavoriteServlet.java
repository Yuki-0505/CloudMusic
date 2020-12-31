package com.swl.servlet;

import com.swl.bean.Favorite;
import com.swl.bean.User;
import com.swl.dao.FavoriteDao;
import com.swl.dao.UserDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@WebServlet(urlPatterns = "/AppendFavoriteServlet")
public class AppendFavoriteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
//      获取前台提交的favoriteName
        String favoriteName = request.getParameter("favoriteName");
        //通过session判断是否登录，未登录则要求用户进行登录
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            // TODO 登录操作，完成后返回到此页
        }
        //获取session中的user对象
        User user = (User) session.getAttribute("user");
        //ServletContext对象
        ServletContext context = request.getServletContext();
        //当前时间对象
        Date date = new Date();
        //计算文件夹实际路径
        String filePath = context.getRealPath("/static/music/" + user.getUserId().toString() + date.getTime());
//      封装数据对象
        Favorite favorite = new Favorite(null, user.getUserId(), favoriteName, filePath, date);
        FavoriteDao favoriteDao = new FavoriteDao();
        //保存favorite到数据库
//      添加
        if (favoriteDao.appendFavorite(favorite)) {
//          成功
            // TODO 新建实际文件夹
            File file = new File(filePath);
            if(file.exists() == false) {
                file.mkdir();
            }
            session.setAttribute("favorite", favorite);
            response.sendRedirect(request.getContextPath() + "/appendFavorite.jsp");
        } else {
//          失败
            response.sendRedirect(request.getContextPath() + "/appendFavorite.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
