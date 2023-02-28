package com.ajc.projetfilrouge.servlet;

import com.ajc.projetfilrouge.dao.Dao;
import com.ajc.projetfilrouge.dao.DaoFactory;
import com.ajc.projetfilrouge.entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/update-user")
public class UpdateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/user-edit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Récupération des données pour la création de compte
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        //TODO Par defaut toujours true: il faudrait donner le choix de la création (à cocher sur jsp)
        Boolean admin = true;
        Boolean activate = true;


        User user = new User(username,email,password,admin, activate);
        Dao<User> userDao = DaoFactory.getUserDao();
        userDao.save(user);

        resp.sendRedirect(req.getContextPath()+"/home");

    }
}