package net.therap.helloworld.controller;

import net.therap.helloworld.dao.UserDao;
import net.therap.helloworld.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/31/12
 * Time: 11:10 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/login")
public class loginController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);    //To change body of overridden methods use File | Settings | File Templates.

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        rd.forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);    //To change body of overridden methods use File | Settings | File Templates.

        UserDao userDao = new UserDao();
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        boolean isTrue = userDao.authenticateUser(user);
        String message = "username or password incorrect";

        //ResultSet rs = null;


            if(isTrue){
                HttpSession session = req.getSession();

                user = userDao.isAdmin(user);
                session.setAttribute("isadmin",user.getISADMIN());
                //System.out.println("session: "+session.getId());
                session.setAttribute("username",user.getUserName());
                resp.sendRedirect("mealplan");



            }
            else{

                System.out.println("this is "+isTrue);
                System.out.println("errors");
                req.setAttribute("error",message);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
                requestDispatcher.forward(req,resp);
            }

    }
}
