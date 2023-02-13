package com.ajc.projetfilrouge.servlet;

import com.ajc.projetfilrouge.dao.DaoFactory;
import com.ajc.projetfilrouge.dao.UserDao;
import com.ajc.projetfilrouge.entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/enable-user")
public class EnableUserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idUser");

        try {
            Long id = Long.parseLong(idStr);
            UserDao dao = DaoFactory.getUserDao();
            Optional<User> user = dao.get(id);

            if (user.isPresent()) {
                user.get().setActivate(true);
            } else {
                return;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }


    }


}
