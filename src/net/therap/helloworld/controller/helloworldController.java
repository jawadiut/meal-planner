package net.therap.helloworld.controller;

import net.therap.helloworld.dao.UserDao;
import net.therap.helloworld.domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: jawad
 * Date: 12/30/12
 * Time: 10:41 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/helloworld.html")
public class helloworldController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);    //To change body of overridden methods use File | Settings | File Templates.
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/helloworld.jsp");
        requestDispatcher.forward(req, resp);
        System.out.println("doGet() called");
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        User user = new User();

        //user.setId(req.getParameter("id"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        user.setConfirmPassword(req.getParameter("confirmPassword"));
        user.setISADMIN(0);
        System.out.println(user);
        /*String userName = req.getParameter("userName");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");*/


        /*System.err.println(userName);
        System.err.println(firstName);
        System.err.println(lastName);
        System.err.println(password);
        System.err.println(confirmPassword);*/
        Map<String,String> message = new HashMap<String,String>();
        if(!validation(user,message)){

            req.setAttribute("error",message);
            req.getRequestDispatcher("/WEB-INF/views/helloworld.jsp").forward(req,resp);


        }
        else{

            Map<String, String> mp = new HashMap<String, String>();
            mp.put("userName", user.getUserName());
            mp.put("firstName", user.getFirstName());
            mp.put("lastName", user.getLastName());
            mp.put("password", user.getPassword());
            mp.put("confirmPassword", user.getConfirmPassword());
            userDao.saveUser(user);
            //List<String> userlist = new ArrayList<String>();
            //req.setAttribute("user",userlist);
            req.setAttribute("user", mp);
            //RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/usershow.jsp");
            //requestDispatcher.forward(req, resp);
            resp.sendRedirect("login");
        }
    }

    private boolean validation(User user,Map<String,String>message){
        boolean isValid = true;
        if(user.getUserName().isEmpty()){
            message.put("username.empty","username is required");
            isValid = false;
        }
        if(user.getEmail().isEmpty()){
            message.put("email.empty","email is empty");
        }
        if(user.getPassword().isEmpty()){
            message.put("password.empty","password is required");
            isValid = false;
        }
        if(!user.getPassword().equals(user.getConfirmPassword())){
            message.put("password.notmatched","password doesnot match");
            isValid = false;
        }
        return isValid;
    }
}
