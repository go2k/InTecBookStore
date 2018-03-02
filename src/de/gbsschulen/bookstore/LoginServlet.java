package de.gbsschulen.bookstore;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    private LoginService loginService = new LoginService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");
        System.out.println(loginname);
        System.out.println(password);
        if (loginService.checkPassword(loginname, password)) {
            req.setAttribute("loginname", loginname);
            req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "LoginServlet war falsch!");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

        }


    }
}
