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
                // TODO: Protéger le superadmin de la suppression : on n'a pas le droit de le supprimer
                // SI on veut supprimer le superadmin qui a l'id 1 (il faut que ce soit son id par défaut)
                if (idStr.equals("1"))
                {
                    // On redirige vers la page des users car on n'a pas le droit de le supprimer (si on peut ajouter un msg d'erreur c'est mieux)
                    resp.sendRedirect(req.getContextPath() + "/user-list");
                }
                // Si c'est un utilisateur autre
                else {
                    //on le supprime de la base
                    dao.delete(user.get());
                    resp.sendRedirect(req.getContextPath() + "/user-list");
                }

            } else {
            }

        } catch (NumberFormatException e) {
            System.err.println(e.getMessage());
        }


    }
}
