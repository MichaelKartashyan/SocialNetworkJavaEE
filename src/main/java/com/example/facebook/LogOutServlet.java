package com.example.facebook;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", value = "/logOut")
public class LogOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("auth");
        Cookie[] cookie = request.getCookies();
        if(cookie!=null){
            for(int i=0;i<cookie.length;i++){

                if(cookie[i].getName().equals("auth")){
                    cookie[i].setValue("");
                    cookie[i].setPath("/");
                    cookie[i].setMaxAge(0);
                    response.addCookie(cookie[i]);
                }
            }
        }
        response.sendRedirect("/index");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
