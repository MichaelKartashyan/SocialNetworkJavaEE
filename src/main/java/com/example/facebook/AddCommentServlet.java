package com.example.facebook;

import DB.DBManager;
import Models.Comment;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "AddCommentServlet", value = "/addcomment")
public class AddCommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String textComment = request.getParameter("textComment");

        Users user = (Users) request.getSession().getAttribute("auth");
        Long postId = Long.parseLong(request.getParameter("postId"));
        Comment comment = new Comment(textComment,postId,user, new Timestamp(System.currentTimeMillis()));


        if(DBManager.addComment(comment)){

        }
    }
}
