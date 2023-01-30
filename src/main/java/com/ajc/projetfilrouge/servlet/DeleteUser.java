package com.ajc.projetfilrouge.servlet;

import com.ajc.projetfilrouge.dao.UserDao;
import com.ajc.projetfilrouge.entites.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.ajc.projetfilrouge.dao.DaoFactory;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/del-user")
public class DeleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("idUser");

        try {
            Long id = Long.parseLong(idStr);
            UserDao dao = DaoFactory.getUserDao();
            Optional<User> user = dao.get(id);

            if (user.isPresent()) {
                dao.delete(user.get());
                resp.sendRedirect(req.getContextPath() + "/user-list");
            } else {
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }


    }
}
