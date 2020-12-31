package com.swl.servlet;

import com.swl.bean.Favorite;
import com.swl.bean.Music;
import com.swl.bean.User;
import com.swl.dao.FavoriteDao;
import com.swl.dao.MusicDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@MultipartConfig()
@WebServlet(urlPatterns = "/AppendMusicServlet")
public class AppendMusicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码方式
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        Part part = request.getPart("music");
//        文件名
        String musicName = part.getSubmittedFileName();

        //通过session判断是否登录，未登录则要求用户进行登录
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            // TODO 登录操作，完成后返回到此页
        }
        //获取session中的user对象
        User user = (User) session.getAttribute("user");
        //获取session中的favorite对象
        Favorite favorite = (Favorite) session.getAttribute("favorite");
        //ServletContext对象
        ServletContext context = request.getServletContext();
        //计算文件夹实际路径
//        String folderPath = favorite.getFilePath();
        String folderPath = "D:/Software/Apache-Tomcat/apache-tomcat-9.0.37/webapps/music/static/music/11609294352279";

//      封装数据对象
//        Music music = new Music(null, favorite.getFavoriteId(), musicName, user.getUserName(), "未知", 0, 0, folderPath + "/" + musicName, new Date());
        Music music = new Music(null, 6, musicName, user.getUserName(), "未知", 0, 0, folderPath + "/" + musicName, new Date());
        //保存music到数据库
        part.write(folderPath + "/" + musicName);
//        保存路径到数据库
//        ResumeDAO resumeDAO = new ResumeDAO();
        MusicDao musicDao = new MusicDao();
//      添加
        if (musicDao.appendMusic(music)) {
//            上传成功
            response.getWriter().println("上传成功");
        } else {
//          失败
            response.getWriter().println("上传失败");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
