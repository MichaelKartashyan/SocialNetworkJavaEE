package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserProfileServlet", value = "/userprofile")
public class UserProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        Users user = DBManager.getUserById(id);
        Users userMe = (Users) request.getSession().getAttribute("auth");
        request.setAttribute("user",user);
        if(DBManager.isFollowToMe(userMe.getId(),user.getId())){
            request.setAttribute("follow",0);
        }else {
            request.setAttribute("follow",1);
        }
        request.getRequestDispatcher("userprofile.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
