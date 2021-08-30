package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditAvatareServlet", value = "/editavatare")
public class EditAvatareServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String avatar = request.getParameter("avatar");
    Users user = (Users) request.getSession().getAttribute("auth");
    if(avatar!=null){
        user.setImagePath(avatar);
        if (DBManager.updateUser(user)) {
            request.setAttribute("successMessage", "Аватар обновлен!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
        } else {
            request.setAttribute("errorMessage", "Ошибка обновления данных!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
        }
    }

    }
}
