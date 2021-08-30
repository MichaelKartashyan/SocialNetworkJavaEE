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

@WebServlet(name = "FollowServlet", value = "/follow")
public class FollowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));


        Users userMe = (Users) request.getSession().getAttribute("auth");
        Users userFollower = DBManager.getUser(id);
        boolean isFollowed =  DBManager.isFollow(userMe.getId(),userFollower.getId());
            PrintWriter out = response.getWriter();
            Gson gson = new Gson();

            out.write(gson.toJson(isFollowed));


    }
}
