package com.example.facebook;

import DB.DBManager;
import Models.Users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditMyProfileServlet", value = "/editmyprofile")
public class EditMyProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("auth")!=null) {
            response.sendRedirect("editmyprofile.jsp");
        }else{
            response.sendRedirect("/index");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/xml; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("uName");
        String surname = request.getParameter("surname");
        String about = request.getParameter("about");
        String email = request.getParameter("email");
        int phone = 0;
        if(!request.getParameter("phone").isEmpty()){ phone = Integer.parseInt(request.getParameter("phone"));}
        String city = request.getParameter("city");
        String university = request.getParameter("university");
        Users user = (Users) request.getSession().getAttribute("auth");


        if(!name.isEmpty()){
            user.setName(name);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите Имя!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(!surname.isEmpty()){
            user.setSurname(surname);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите Фамилию!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(!about.isEmpty()){
            user.setAbout(about);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите что нибудь о себе!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(!email.isEmpty()){
            //if (!DBManager.isExist(email)) {
                user.setEmail(email);
           // }else{
               // request.setAttribute("errorMessage","Пользователь с таким email'ом уже существует!");
               // request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
            }

        //}
        else{
            request.setAttribute("errorMessage","Пожалуйста введите Email!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(phone>0){
            user.setPhone(phone);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите Номер!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(!city.isEmpty()){
            user.setCity(city);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите Город!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }
        if(!university.isEmpty()){
            user.setUniversity(university);
        }else{
            request.setAttribute("errorMessage","Пожалуйста введите Место учебы!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }

        if(DBManager.updateUser(user)){
            request.setAttribute("successMessage","Данные успешно обновлены!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }else{
            request.setAttribute("errorMessage","Ошибка обновления данных!");
            request.getRequestDispatcher("/editmyprofile.jsp").forward(request,response);
        }

    }
}
