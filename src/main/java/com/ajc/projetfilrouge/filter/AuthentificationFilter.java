package com.ajc.projetfilrouge.filter;


import com.ajc.projetfilrouge.servlet.LoginServlet;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebFilter(urlPatterns = {"/user/*", "/logout"})
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String uri = req.getRequestURI();
        System.out.println(uri);


        // Get existing session or return null
        boolean wantCreateIfNotExist = false;
        HttpSession session = req.getSession(wantCreateIfNotExist);

        if (session != null && session.getAttribute("username") != null) {
            // Filtrage OK
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect(LoginServlet.URL);
        }

    }


}