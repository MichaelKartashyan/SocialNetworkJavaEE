package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth")
public class AuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Users user =  DBManager.logIn(email,password);

        if(user.getEmail()!=null){
            HttpSession session = request.getSession();
            session.setAttribute("auth",user);

            Cookie cookieAuth = new Cookie("auth",user.getEmail());

            cookieAuth.setMaxAge(3600*24*30);
            response.addCookie(cookieAuth);
            response.sendRedirect("/home");
        }else{
            request.setAttribute("errorMessage"," The password you’ve entered is incorrect.");
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}
