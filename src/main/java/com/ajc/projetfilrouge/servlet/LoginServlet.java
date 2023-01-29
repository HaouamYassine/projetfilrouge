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
import org.hibernate.internal.build.AllowSysOut;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet (urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

   //public static final String URL = "/login";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("username") != null) {
            resp.sendRedirect("login.jsp");
        } else {
            req.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(req, resp);
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");



        //TO DO : change if avec les données récupérées en BDD et plus en dur
        //Vérification en BDD
        /*
        1-
        2- Si le champs entré par l'utilisateur est présent dans la liste (fetch la base sur le champ username):
                Alors on va prendre le mdp en BDD correspondant.
                      Si ce mdp en BDD == au password entré par l'utilisateur
                            Alors la connexion est bonne
                      Sinon: password doesn't match username
                Sinon: no username found


2 manière: soit chercher via email, method finduserbyemail (classe UserDao) puis l'implémenter dans UserJPADao

                chercher via username, method getUserByName (classe UserDao) puis l'implémenter dans UserJPADao

        */

        UserDao dao = DaoFactory.getUserDao();
        Optional<User> user = dao.getUserByName(username);

        if (user.isPresent()) {
            String passwordBDD = user.get().getPassword();
            //check MDP

            // Si le MDP est identique à l'entrée utilisateur
            if (password.equals(passwordBDD)) {
                // Get existing session or create one if not exist
                HttpSession session = req.getSession(true);

                session.setAttribute("username", username);
                // Si c'est le super admin qui est co on set la valeur à true (pour débloquer la création d'admin via la navbar)
                String admin=user.get().getUsername();
                if (admin.equals("admin")) {
                session.setAttribute("admin", true);
                }
                // Expiration after 30 minutesstatus
                session.setMaxInactiveInterval(30 * 60);
                resp.sendRedirect("/home");


            }
            else if (password!=passwordBDD){// mauvais mdp correspondant
                String msg ="mauvais mot de passe";
                System.out.println(msg);
                req.setAttribute("loginFail", true);
                doGet(req, resp);

            }
        } else {// username pas dans la BDD
            String msg ="nom d'utilisateur introuvable";
            System.out.println(msg);
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }

        //for (String usernameDB : user:



        // TEST DE CONNEXION EN DUR  EN MODE SUPER ADMIN
//        if (username.equals("admin") && password.equals("admin")) {
//            // Get existing session or create one if not exist
//            HttpSession session = req.getSession(true);
//
//            session.setAttribute("username", username);
//            // Creation d'un attribut admin, pour tester la navbar avec un super admin
//            session.setAttribute("admin", true);
//            // Expiration after 30 minutes
//            session.setMaxInactiveInterval(30 * 60);
//
//
//            resp.sendRedirect("/home");
//        } else {
//            req.setAttribute("loginFail", true);
//            doGet(req, resp);
//        }
    }
}
