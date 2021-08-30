package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditPasswordServlet", value = "/editpassword")
public class EditPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        Users user = (Users) request.getSession().getAttribute("auth");
        System.out.println(password+" "+ repassword);


            if (password.equals(repassword)&password!=null) {

                if (!password.equals(user.getPassword())) {
                    user.setPassword(password);
                    if (DBManager.updateUser(user)) {
                        request.setAttribute("successMessage", "Данные успешно обновлены!");
                        request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errorMessage", "Ошибка обновления данных!");
                        request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("errorMessage", "Ваш пароль идентичен новому паролю!");
                    request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("errorMessage", "Пароли не совпадают!");
                request.getRequestDispatcher("/editmyprofile.jsp").forward(request, response);
            }



    }
}
