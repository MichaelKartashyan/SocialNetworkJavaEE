package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", value = "/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String bDate = request.getParameter("day")+" "+request.getParameter("month")+" "+request.getParameter("year");
        String gender = request.getParameter("sex");

        Users user = new Users(name,surname,password,email,bDate,gender);
        if(name!=null &surname!=null&email!=null&password!=null&bDate!=null&gender!=null) {
            if (!DBManager.isExist(email)) {
                if (DBManager.addUser(user)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("auth", user);

                    Cookie cookieAuth = new Cookie("auth", email);
                    cookieAuth.setMaxAge(3600 * 24 * 30);
                    response.addCookie(cookieAuth);


                    response.sendRedirect("/home");
                } else {
                    request.setAttribute("errorMessage", "Error create Account");
                    request.getRequestDispatcher("/index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Email is already exist");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        }else {
            request.setAttribute("errorMessage", "Please enter all data");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }
}
