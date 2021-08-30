package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "IndexServlet", value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Boolean auth = false;
       String email = "";
        Cookie[] cookie = request.getCookies();
        if(cookie!=null){
            for(int i=0;i<cookie.length;i++){

                if(cookie[i].getName().equals("auth")){
                    auth = true;
                    email = cookie[i].getValue();
                }
            }
        }


       if(auth==true){
           Users user = DBManager.getUserByEmail(email);
               HttpSession session = request.getSession();
               session.setAttribute("auth",user);

               response.sendRedirect("/home");
       }else{
           response.sendRedirect("/index.jsp");
       }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
