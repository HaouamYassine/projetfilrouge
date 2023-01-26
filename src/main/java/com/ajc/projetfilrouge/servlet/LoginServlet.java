package com.ajc.projetfilrouge.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
        if (username.equals("admin") && password.equals("admin")) {
            // Get existing session or create one if not exist
            HttpSession session = req.getSession(true);

            session.setAttribute("username", username);
            // Expiration after 30 minutes
           // session.setMaxInactiveInterval(30 * 60);


            resp.sendRedirect("/home");
        } else {
            req.setAttribute("loginFail", true);
            doGet(req, resp);
        }
    }
}
