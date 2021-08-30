package com.example.facebook;

import DB.DBManager;
import Models.Post;
import Models.Users;
import com.google.gson.Gson;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;

@WebServlet(name = "AddPostServlet", value = "/addpost")
public class AddPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String textPost = request.getParameter("textPost");
        Long forUsers = Long.parseLong(request.getParameter("forUsers"));
        Users user = (Users) request.getSession().getAttribute("auth");


        if(textPost!=null){
            Post post = new Post(textPost,new Timestamp(System.currentTimeMillis()),user,0,forUsers);
            DBManager.addPost(post);

            }
        }
    }

