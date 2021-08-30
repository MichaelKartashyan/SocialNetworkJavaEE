package com.example.facebook;

import DB.DBManager;
import Models.Post;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LikePostServlet", value = "/likePost")
public class LikePostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Post post = DBManager.getPost(id);
        Users user = (Users) request.getSession().getAttribute("auth");
        //если юзер уже ставил лайк
        if(DBManager.isLikedPost(user.getId(),id)){
            //количество лайков
            int like = post.getCountLike();
            post.setCountLike(--like);
            //заливаем коменты в базу коментов
            DBManager.updatePost(post);
            //делаем так как будто пользователь еще не лайкал
            int doLike = 0;
            DBManager.updateLikePost(user.getId(),id,doLike);
            // response.sendRedirect("/detailNew?id=" + postId);
        }else{
            if(DBManager.isLikeExist(user.getId(),id)){
                //если такой записи о лайках пользователя еще нету
                DBManager.addLikePost(user.getId(),id);
            }
            //количество лайков
            int like = post.getCountLike();
            post.setCountLike(++like);
            //заливаем коменты в базу коментов
            DBManager.updatePost(post);
            //делаем так как будто пользователь уже  пролайкал
            int doLike = 1;
            DBManager.updateLikePost(user.getId(),id,doLike);
            // response.sendRedirect("/detailNew?id=" + postId);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
