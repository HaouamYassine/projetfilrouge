package com.ajc.projetfilrouge.servlet;

import com.ajc.projetfilrouge.dao.DaoFactory;
import com.ajc.projetfilrouge.dao.UserDao;
import com.ajc.projetfilrouge.entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/user-list")
public class UserList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserDao dao = DaoFactory.getUserDao();
        List<User> userList = dao.getAll();

        req.setAttribute("users", userList);
        req.getRequestDispatcher("/WEB-INF/user-list.jsp").forward(req,resp);
    }
}
