package net.therap.helloworld.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 1/4/13
 * Time: 5:11 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
        HttpSession session = req.getSession(false);
        //if(session.isNew()) System.out.println("Whoa!!! new session???");
        if(session!=null) session.invalidate();
        resp.sendRedirect("login");
        //getServletContext().getRequestDispatcher("/WEB-INF/views/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
    }
}
